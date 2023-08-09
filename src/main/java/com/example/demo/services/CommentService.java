package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Comments;

public interface CommentService {

	List<Comments> commentList();

	String addComment(Comments comment);
}
