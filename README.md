# 💳 Simulateur ISO 8583 – Projet de Fin d'Études

Ce projet implémente un **simulateur de transactions électroniques bancaires** basé sur le protocole **ISO 8583**, selon une **architecture microservices** modulaire et extensible. Il est destiné à simuler les messages de paiement, les analyser, et les enregistrer dans une base de données.

---

## 🎯 Objectifs

- Générer dynamiquement des messages ISO 8583
- Simuler un système bancaire récepteur
- Centraliser la découverte des services via Eureka
- Stocker les transactions dans une base relationnelle
- Travailler en architecture distribuée avec Spring Boot

---

## 🧱 Microservices réalisés



### 📡 1. `eureka-service`
> Service de découverte Eureka (registre).

- 📌 Port : `8761`
- Interface Web : [http://localhost:8761](http://localhost:8761)
- Ne conserve pas de logique métier, il sert à enregistrer les microservices.
- 
---

### 2️⃣ `packing-iso-service`
**Rôle :** Génère un message ISO 8583 à partir d’une transaction (entrée utilisateur).

- Port : `8081`
- Fonctionnalités :
  - Exposition d’une API REST (`/api/packing/iso`)
  - Génération dynamique du **MTI** et des champs ISO (ex. PAN, Amount, Code Traitement…)
  - Encodage des messages selon les spécifications ISO 8583
  - Enregistrement automatique dans Eureka

---

### 3️⃣ `response-iso-service`
**Rôle :** Réceptionne le message ISO généré, simule une réponse, et enregistre le tout dans une base de données.

- Port : `8082`
- Fonctionnalités :
  - Exposition d’un endpoint `/api/iso/response`
  - Réception et **analyse des messages ISO**
  - Génération de réponse simulée (ex. code réponse `00`, `51`, etc.)
  - **Enregistrement dans MySQL** (ou H2 pour test)
  - Requête possible sur les messages stockés



----------

## 👤 Auteur
Mohamed BOUDANE
📍 EMSI Casablanca – Filière MIAGE
📅 Projet de Fin d’Études – 2025
🔗 GitHub MohamedBOUDANE026
---


