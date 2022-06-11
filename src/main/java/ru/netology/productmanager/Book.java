package ru.netology.productmanager;

public class Book  extends Product{
   private String author;

   public Book (int bookId, String bookTitle,String bookAuthor){
       super.id = bookId;

       super.name = bookTitle;

       this.author= bookAuthor;
   }


}
