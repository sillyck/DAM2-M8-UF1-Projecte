package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.core.app.CoreComponentFactory;

@SuppressWarnings({"FieldCanBeLocal", "unused", "SpellCheckingInspection"})
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

		imageButton001.setOnClickListener(v -> answerCommonOnClick(1));
		imageButton002.setOnClickListener(v -> answerCommonOnClick(2));
		imageButton003.setOnClickListener(v -> answerCommonOnClick(3));
		imageButton004.setOnClickListener(v -> answerCommonOnClick(4));
		imageButton005.setOnClickListener(v -> answerCommonOnClick(5));
		imageButton006.setOnClickListener(v -> answerCommonOnClick(6));
		imageButton007.setOnClickListener(v -> answerCommonOnClick(7));
		imageButton008.setOnClickListener(v -> answerCommonOnClick(8));
		imageButton009.setOnClickListener(v -> answerCommonOnClick(9));
		imageButton010.setOnClickListener(v -> answerCommonOnClick(10));
		imageButton011.setOnClickListener(v -> answerCommonOnClick(11));
		imageButton012.setOnClickListener(v -> answerCommonOnClick(12));
		imageButtonContinuar.setOnClickListener(v -> imageButtonContinuarOnClick());

		setThingsToQuestion(LogicSingleton.GetCurrentQuestion());

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

	public void imageButtonContinuarOnClick(/*View v*/)
	{
		Intent intent = new Intent(LogicSingleton.NextQuestion(PantallaBotonsImatge.this));
		startActivity(intent);
	}

	public void answerCommonOnClick(int click)
	{
		if(state==1)
		{
			setState(2);
			selectedAnswer = click;
			highlightAnswers(true);
		}
	}

	@SuppressWarnings("ConstantConditions")
	public void highlightAnswers(boolean highlight)
	{
		if(selectedAnswer!=-1 && selectedAnswer==correctAnswer)
		{
			didItGetItRight = 1;
			if(highlight) paintColourTableButton(selectedAnswer,true);
		}
		else if(selectedAnswer!=-1 && selectedAnswer!=correctAnswer)
		{
			didItGetItRight = 0;
			if(highlight) paintColourTableButton(selectedAnswer,false);
		}
	}

	@SuppressWarnings("unused")
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
			case  1: imageButton001.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case  2: imageButton002.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case  3: imageButton003.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case  4: imageButton004.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case  5: imageButton005.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case  6: imageButton006.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case  7: imageButton007.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case  8: imageButton008.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case  9: imageButton009.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case 10: imageButton010.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case 11: imageButton011.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
			case 12: imageButton012.setBackgroundColor(correct ? Color.rgb(0,255,0) : Color.rgb(255,0,0)); break;
		}
	}

	public void setThingsToQuestion(int question)
	{
//		switch(question)
//		{
//			case 1:
				correctAnswer = Integer.parseInt(LogicSingleton.getCurrentQuestionInformation().answers[0]);
				textViewTitle.setText(LogicSingleton.getCurrentQuestionInformation().questionTitle);
				imageView.setImageResource(getResources().getIdentifier(LogicSingleton.getCurrentQuestionInformation().images[0],"drawable",getPackageName()));
//				break;
//			case 2: startActivity(new Intent(PantallaBotonsImatge.this,LogicSingleton.getCurrentQuestionInformation().questionClass));
//			default: setThingsToQuestion(1); break;
//		}
	}
}