# 💳 Simulateur ISO 8583 - Microservices Architecture

Ce projet simule un système de traitement de transactions basé sur le protocole ISO 8583 en utilisant une architecture microservices avec Spring Boot et Spring Cloud.

---

## 🧱 Architecture globale du projet :


---![Architecture_PFE ](https://github.com/user-attachments/assets/42092591-8e5d-4f4d-9938-d7d0c6445b25)


## ⚙️ Microservices inclus

### 1. 🛰 **Eureka Service**
- Service de **discovery** (Service Registry)
- Port : `8761`
- URL : `http://localhost:8761`
- Permet à tous les services de s’enregistrer et de se découvrir mutuellement

---

### 2. 📦 **Packing ISO Service**
- Génère le message ISO 8583 à partir des informations de transaction
- URL exposée : `POST /api/iso/generate`
- Port : `8081`

---

### 3. 📊 **Response ISO Service**
- Analyse le message ISO reçu
- Enregistre le message + code réponse en base de données MySQL
- URL exposée : `POST /api/response/save`
- Port : `8082`

---

### 4. 🔁 **Transaction Service (Orchestrateur)**
- Reçoit les données de transaction via l’utilisateur
- Orchestration : appelle PackingISO → puis ResponseISO
- Retourne une réponse enrichie (message ISO + code + description)
- URL exposée : `POST /api/transaction/process`
- Port : `8083`

---

### 💾 Base de données
Type : MySQL

Nom : iso_db

Table : iso_message_entity

Contenu : message brut, code réponse, date de réception


### 📌 Stack technique
Java 17+

Spring Boot

Spring Cloud Eureka

Spring Data JPA

FeignClient

MySQL 8

Lombok



#### 👨‍💻 Auteur

 Réalisé par **Mohamed BOUDANE**

Projet de **_simulation de transactions ISO 8583_** – version finale stable 🚀





