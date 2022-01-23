# A simple CRUD using Clean Architecture in Java

This project is an example of clean architecture using Java.

![alt text](https://github.com/leoee/clean-arch-java/blob/main/clean_arch_image.png?raw=true)

## Domain
* Contains all models and global exceptions related to the bussiness rules.

## Usecases
* Contains our bussiness cases, it is what the application can do without knowing who will call;
* Define interfaces for repositories;
* It uses model declared on the domain;
* Only java code, no frameworks and annotations.

## Presentation
* Work as an interface adapter;
* Contains the controller of the application providing access to the usecases;
* It is responsible to convert data from the format most convenient for the usecases and entities, to the format most convenient for external players, like database and websecurity.

## Infra
* Handle external frameworks/drivers. Example: database, websecurity, etc;
* Implements database interfaces defined on the usecases;
* Wires everything together.


