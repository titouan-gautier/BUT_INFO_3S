<?php

Interface ProductRepositoryInterface
{
    public function findAll(): array;
    public function findById(int $id):?ProductEntity;
    public function add(ProductEntity $product):?ProductEntity;
    public function update(int $id, ProductEntity $product):?ProductEntity;
    public function delete(int $id): bool;

}