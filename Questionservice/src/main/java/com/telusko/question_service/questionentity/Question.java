package com.telusko.question_service.questionentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightAnswer;
	@Column(name = "question_title")
	private String questionTitle;
	private String category;

	@Column(name = "dificultylevel")
	private String difficultylevel;

	public Integer getId() {
		return id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}
	public String getOption1() {
		return option1;
	}
	public String getOption2() {
		return option2;
	}
	public String getOption3() {
		return option3;
	}
	public String getOption4() {
		return option4;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public String getCategory() {
		return category;
	}

}
