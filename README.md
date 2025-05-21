# 📦 product-service

`product-service` est un microservice dédié à la gestion des produits dans une architecture microservices. Il offre des fonctionnalités de création, consultation, suppression et recherche avancée de produits avec pagination, filtres dynamiques, et gestion des catégories associées.

---

## 🎯 Objectifs

- Gérer les entités `Product` et `Category`
- Permettre des **recherches dynamiques multi-critères**
- Fournir des réponses structurées en DTO
- Offrir un service RESTful modulaire et extensible
- S'intégrer avec Eureka et l'API Gateway

---

## 📄 Fonctionnalités principales

- 🔍 Recherche de produits avec pagination et `Specification`
- 🆕 Création d’un produit lié à une catégorie
- 🔁 Mapping via `ProductMapper` et `CategoryMapper`
- 📚 Support Swagger/OpenAPI via Springdoc
- 🧪 Prêt pour l’intégration avec d'autres microservices

---

## ⚙️ Technologies utilisées

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA + Specification API**
- **PostgreSQL**
- **Lombok**
- **MapStruct ou Java functional mappers**
- **Swagger (Springdoc)**

---

## 🧩 Exemple de requête filtrée

```http
GET /api/products/search?page=0&size=10&name=tv&minPrice=100&maxPrice=1000&categoryId=1



{
  "name": "Samsung Smart TV",
  "description": "Téléviseur 55 pouces UHD",
  "price": 899.99,
  "categoryId": 1
}
