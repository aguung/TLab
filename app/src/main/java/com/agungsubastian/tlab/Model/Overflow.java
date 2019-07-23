package com.agungsubastian.tlab.Model;

public class Overflow implements IOverflow {

    String name,title,image,create;

    public Overflow(String name, String title, String image, String create){
        this.name = name;
        this.title = title;
        this.image = image;
        this.create= create;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getCreate() {
        return create;
    }
}
