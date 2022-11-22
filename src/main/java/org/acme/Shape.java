/*
 * Copyright (c) 2022 by Bank Lombard Odier & Co Ltd, Geneva, Switzerland. This software is subject
 * to copyright protection under the laws of Switzerland and other countries. ALL RIGHTS RESERVED.
 *
 */

package org.acme;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonPropertyOrder({ "type" })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Shape.Circle.class, name = ".Circle"),
        @JsonSubTypes.Type(value = Shape.Square.class, name = ".Square") })
public abstract class Shape {
    @JsonTypeName(".Circle")
    public static class Circle extends Shape {
        public String attChildA = "circle";
    }

    @JsonTypeName(".Square")
    public static class Square extends Shape {
        public String attChildB = "square";
    }
}

