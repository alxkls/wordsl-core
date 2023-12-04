#!/bin/sh
#Author: Alxkls
#Script to run the app

#Deploying postgres on k8s
kubectl apply -f k8s/postgres/postgres-deploy.yaml
kubectl apply -f k8s/postgres/postgres-svc.yaml

mvn clean install

kubectl delete deploy wordsl-core-deploy
docker rmi wordsl-core:1

docker build -t wordsl-core:1 .

#deploying core app on k8s
kubectl apply -f k8s/wordsl/wordsl-core-deploy.yaml
kubectl apply -f k8s/wordsl/wordsl-core-svc.yaml