package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class PantallaBotonsImatge extends AppCompatActivity
{
	public int state = 0;
	public int question = -1;
	public int correctAnswer = -1;
	public int selectedAnswer = -1;
	public int didItGetItRight = -1; //-1: Not answered yet; 0: Wrong answer; 1: Correct answer

	private LinearLayout linearLayoutPregunta, linearLayoutResposta, linearLayoutContinuar;
	private ImageButton imageButton001, imageButton002, imageButton003, imageButton004,
						imageButton005, imageButton006, imageButton007, imageButton008,
						imageButton009, imageButton010, imageButton011, imageButton012;
	private ImageButton imageButtonPregunta, imageButtonResposta, imageButtonContinuar;
	private TextView textViewPregunta, textViewResposta, textViewTitle;
	private ImageView imageView;
	private TableLayout tableLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_botons_imatge);

		identificarComponents();
//		imageButtonPregunta.setMaxHeight(imageButtonPregunta.getWidth());
//		imageButtonPregunta.setMinimumHeight(imageButtonPregunta.getWidth());
//		imageButtonResposta.setMaxHeight(imageButtonResposta.getWidth());
//		imageButtonResposta.setMinimumHeight(imageButtonResposta.getWidth());
//		imageButtonContinuar.setMaxHeight(imageButtonContinuar.getWidth());
//		imageButtonContinuar.setMinimumHeight(imageButtonContinuar.getWidth());
//
//		int width = imageButtonPregunta.getMeasuredWidth();
//		int height = imageButtonPregunta.getMeasuredHeight();
//
		// Optimization so we don't measure twice unless we need to
//		if (width != height) {
//			imageButtonPregunta.setMeasuredDimension(width, width);
//		}

//		ImageButton ib = (ImageButton) findViewById(R.id.myImageButton);
//		ib.setMaxHeight(ib.getWidth());
//		imageButtonPregunta.setMaxHeight(imageButtonPregunta.getWidth());

		setState(0);
	}

	public void setState(int state)
	{
		System.out.println(state);
		this.state = state;
		changeComponentStates(state);
	}

	public void changeComponentStates(int state)
	{
		linearLayoutPregunta.setVisibility(View.GONE);
		linearLayoutResposta.setVisibility(View.GONE);
		linearLayoutContinuar.setVisibility(View.GONE);
		tableLayout.setVisibility(View.GONE);
		textViewTitle.setVisibility(View.GONE);
		imageView.setVisibility(View.GONE);
		switch(state)
		{
			case 0:
				linearLayoutPregunta.setVisibility(View.GONE);
				linearLayoutResposta.setVisibility(View.VISIBLE);
				linearLayoutContinuar.setVisibility(View.GONE);
				tableLayout.setVisibility(View.GONE);
				textViewTitle.setVisibility(View.VISIBLE);
				imageView.setVisibility(View.VISIBLE);
				break;
			case 1:
				linearLayoutPregunta.setVisibility(View.VISIBLE);
				linearLayoutResposta.setVisibility(View.GONE);
				linearLayoutContinuar.setVisibility(View.GONE);
				tableLayout.setVisibility(View.VISIBLE);
				textViewTitle.setVisibility(View.GONE);
				imageView.setVisibility(View.GONE);
				break;
			case 2:
				linearLayoutPregunta.setVisibility(View.GONE);
				linearLayoutResposta.setVisibility(View.GONE);
				linearLayoutContinuar.setVisibility(View.VISIBLE);
				tableLayout.setVisibility(View.VISIBLE);
				textViewTitle.setVisibility(View.GONE);
				imageView.setVisibility(View.GONE);
			break;
		}
	}

	private void identificarComponents()
	{
		linearLayoutPregunta = findViewById(R.id.linearLayoutPregunta);
		linearLayoutResposta = findViewById(R.id.linearLayoutResposta);
		linearLayoutContinuar = findViewById(R.id.linearLayoutContinuar);
		imageButtonPregunta = findViewById(R.id.imageButtonPregunta);
		imageButtonResposta = findViewById(R.id.imageButtonResposta);
		imageButtonContinuar = findViewById(R.id.imageButtonContinuar);
		textViewPregunta = findViewById(R.id.textViewPregunta);
		textViewResposta = findViewById(R.id.textViewRespota);
		textViewTitle = findViewById(R.id.textViewTitle);
		tableLayout = findViewById(R.id.tableLayout);
		imageView = findViewById(R.id.imageViewMain);
		imageButton001 = findViewById(R.id.imageButton001);
		imageButton002 = findViewById(R.id.imageButton002);
		imageButton003 = findViewById(R.id.imageButton003);
		imageButton004 = findViewById(R.id.imageButton004);
		imageButton005 = findViewById(R.id.imageButton005);
		imageButton006 = findViewById(R.id.imageButton006);
		imageButton007 = findViewById(R.id.imageButton007);
		imageButton008 = findViewById(R.id.imageButton008);
		imageButton009 = findViewById(R.id.imageButton009);
		imageButton010 = findViewById(R.id.imageButton010);
		imageButton011 = findViewById(R.id.imageButton011);
		imageButton012 = findViewById(R.id.imageButton012);
	}

	public void imageButtonPreguntaOnClick(View v)
	{
		setState(0);
	}

	public void imageButtonRespostaOnClick(View v)
	{
		setState(1);
	}

	public void imageButtonContinuarOnClick(View v)
	{
		setState(2);
	}

	public void answerCommonOnClick(int click)
	{
		if(state==1)
		{
		setState(2);
		selectedAnswer = click;
		highlightAnswers();
		}
	}

	public void highlightAnswers()
	{
		if(selectedAnswer!=-1 && selectedAnswer==correctAnswer)
		{
			paintColourTableButton(selectedAnswer,true);
		}
		else if(selectedAnswer!=-1 && selectedAnswer!=correctAnswer)
		{
			paintColourTableButton(selectedAnswer,false);
		}
	}

	public void paintColourTableButton(int column, int row, boolean correct)
	{
		paintColourTableButton(column,row,correct,true);
	}

	public void paintColourTableButton(int column, int row, boolean correct, boolean startsAtZero)
	{
		if(!startsAtZero)
		{
			column++;
			row++;
		}
			 if(row==0 && column==0) paintColourTableButton( 1,correct);
		else if(row==0 && column==1) paintColourTableButton( 2,correct);
		else if(row==0 && column==2) paintColourTableButton( 3,correct);
		else if(row==1 && column==0) paintColourTableButton( 4,correct);
		else if(row==1 && column==1) paintColourTableButton( 5,correct);
		else if(row==1 && column==2) paintColourTableButton( 6,correct);
		else if(row==2 && column==0) paintColourTableButton( 7,correct);
		else if(row==2 && column==1) paintColourTableButton( 8,correct);
		else if(row==2 && column==2) paintColourTableButton( 9,correct);
		else if(row==3 && column==0) paintColourTableButton(10,correct);
		else if(row==3 && column==1) paintColourTableButton(11,correct);
		else if(row==3 && column==2) paintColourTableButton(12,correct);
	}

	public void paintColourTableButton(int num, boolean correct)
	{
		switch(num)
		{
			case  1: imageButton001.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case  2: imageButton002.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case  3: imageButton003.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case  4: imageButton004.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case  5: imageButton005.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case  6: imageButton006.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case  7: imageButton007.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case  8: imageButton008.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case  9: imageButton009.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case 10: imageButton010.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case 11: imageButton011.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
			case 12: imageButton012.setBackgroundTintList(correct ? ColorStateList.valueOf(getResources().getColor(R.color.teal_200)) : ColorStateList.valueOf(getResources().getColor(R.color.purple_200))); break;
		}
	}
}