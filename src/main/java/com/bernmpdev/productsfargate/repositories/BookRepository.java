package com.bernmpdev.productsfargate.repositories;

import com.bernmpdev.productsfargate.models.Book;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;

@Repository
public class BookRepository {
    private final DynamoDbTable<Book> bookTable;

    public BookRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {

        this.bookTable = dynamoDbEnhancedClient.table("Books", TableSchema.fromBean(Book.class));
    }

    public List<Book> getAll() {
        return this.bookTable.scan().items().stream().toList();
    }

    public Book getById(String id) {
        return this.bookTable.getItem(r -> r.key(k -> k.partitionValue(id)));
    }

}