package com.nr.springmvc.model;

public class QuestionResult {
	private Long id;
	private static String noOfQuestion;
	private static long correctAnswer;
	private static  long wrongAnswer;
	private static double result;
	
	
	 public QuestionResult() {
	 System.out.println("QuestionResult=>D.C");
	}


	public QuestionResult(Long id, String noOfQuestion, long correctAnswer, long wrongAnswer, double result) {
		super();
		this.id = id;
		this.noOfQuestion = noOfQuestion;
		this.correctAnswer = correctAnswer;
		this.wrongAnswer = wrongAnswer;
		this.result = result;
	}


	 
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public static String getNoOfQuestion() {
		return noOfQuestion;
	}


	public static void setNoOfQuestion(String noOfQuestion) {
		QuestionResult.noOfQuestion = noOfQuestion;
	}


	public static long getCorrectAnswer() {
		return correctAnswer;
	}


	public static void setCorrectAnswer(long correctAnswer) {
		QuestionResult.correctAnswer = correctAnswer;
	}


	public static long getWrongAnswer() {
		return wrongAnswer;
	}


	public static void setWrongAnswer(long wrongAnswer) {
		QuestionResult.wrongAnswer = wrongAnswer;
	}


	public static double getResult() {
		return result;
	}


	public static void setResult(double result) {
		QuestionResult.result = result;
	}


	@Override
	public String toString() {
		return "QuestionResult [id=" + id + ", noOfQuestion=" + noOfQuestion + ", correctAnswer=" + correctAnswer
				+ ", wrongAnswer=" + wrongAnswer + ", result=" + result + "]";
	}
	 
	 
	 
	
	
	

}
