package com.example.ordermanagement.service;

/**
 * MARK: Status
 * DESC: Stores the enum types for status. Why not another table? this approach saves db memory by reducing another table creation for status
 */

public enum Status {
    INITIATED,
    CONFIRMED,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
