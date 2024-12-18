# Havayolu Yönetim Sistemi

Bu proje, bir havayolu şirketinin temel operasyonlarını yönetmek için geliştirilmiş mikroservis tabanlı bir sistemdir.

## Mikroservisler

### 1. Uçak Servisi (airplane-service)
Uçak ve koltuk yönetimi için geliştirilen servis.

**Temel Özellikler:**
- Uçak kaydı ve yönetimi
- Koltuk düzeni ve özellikleri yönetimi
- Uçak detayları sorgulama

**API Endpointleri:**
- `/api/planes`: Uçak işlemleri
- `/api/seats`: Koltuk işlemleri

### 2. Uçuş Servisi (flight-service) 
Uçuş operasyonları ve havaalanı yönetimi için geliştirilen servis.

**Temel Özellikler:**
- Uçuş planlaması ve takibi
- Havaalanı bilgileri yönetimi
- Uçuş tarifesi yönetimi

**API Endpointleri:**
- `/api/flights`: Uçuş işlemleri
- `/api/airports`: Havaalanı işlemleri
- `/api/schedules`: Uçuş tarifesi işlemleri

### 3. Kullanıcı Bilgi Servisi (user-info-service)
Kullanıcı, personel ve kabin ekibi yönetimi için geliştirilen servis.

**Temel Özellikler:**
- Kullanıcı hesap yönetimi
- Personel kaydı ve yönetimi
- Kabin ekibi atamaları

**API Endpointleri:**
- `/api/users`: Kullanıcı işlemleri
- `/api/staff`: Personel işlemleri
- `/api/cabin-crew`: Kabin ekibi işlemleri

## Teknolojiler

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Spring Cloud OpenFeign (Mikroservis iletişimi için)

## Kurulum

1. PostgreSQL veritabanını kurun ve `AIRLINE` adında bir veritabanı oluşturun

2. Her bir servis için: 