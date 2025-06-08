#!/bin/bash

# Variáveis
RESOURCE_GROUP=helpleave-rg
ACR_NAME=helpleavecr
IMAGE_NAME=helpleave-api
APP_NAME=helpleave-api-app
LOCATION=brazilsouth
PLAN_NAME=helpleave-plan

echo "➡️ Login no Azure..."
az login

echo "➡️ Criando grupo de recursos (se necessário)..."
az group create --name $RESOURCE_GROUP --location $LOCATION

echo "➡️ Criando Azure Container Registry (se necessário)..."
az acr create --resource-group $RESOURCE_GROUP --name $ACR_NAME --sku Basic --admin-enabled true

echo "➡️ Login no ACR..."
az acr login --name $ACR_NAME

echo "➡️ Build da imagem Docker e envio para ACR..."
az acr build --registry $ACR_NAME --image $IMAGE_NAME .

echo "➡️ Criando App Service Plan (se necessário)..."
az appservice plan create --name $PLAN_NAME --resource-group $RESOURCE_GROUP --is-linux --sku B1

echo "➡️ Criando Web App..."
az webapp create \
  --resource-group $RESOURCE_GROUP \
  --plan $PLAN_NAME \
  --name $APP_NAME \
  --deployment-container-image-name $ACR_NAME.azurecr.io/$IMAGE_NAME:latest \
  --docker-registry-server-url https://$ACR_NAME.azurecr.io

echo "✅ Deploy completo!"
