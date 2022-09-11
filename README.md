# 従業員管理サンプルアプリケーション

## このリポジトリについて
このリポジトリは、従業員を管理する Web アプリケーションを格納しています。Frontend は React で実装され、`react-sample`フォルダに格納しており、Backend は Spring Boot で実装され、`spring-boot-aks`フォルダに格納しています。各フォルダにローカルでの実行手順とデプロイ方法を説明しています。デプロイは Azure のサービスを利用して行いますが、Azure に関する環境構築説明はここで割愛します。

## Frontend について
- Framework: React
- Language: JavaScript
- 実行環境: Node v16.15.1

## Backend について
- Framework: Spring Boot 2.7.0
- Language: Java

## ローカル環境について
- Homebrew: 3.5.9
- Docker: v20.10.17
- Maven: v3.8.6
- JDK: openjdk version "17.0.3"

## 利用する Azure のサービス
- Virtual Machine
- Azure Kubernetes Service
- Azure Container Registry
- Azure Cache for Redis
- Azure SQL Database
