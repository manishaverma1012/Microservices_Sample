package com.example.HotelService.HotelService.Exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message)
    {
        super(message);

    }
    public ResourceNotFound()
    {
        super("Resource Not found");
    }
}
