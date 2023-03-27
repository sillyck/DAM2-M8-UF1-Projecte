package com.example.orgue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

@SuppressWarnings({"FieldCanBeLocal", "unused", "SpellCheckingInspection"})
public class PantallaBotonsImatge extends AppCompatActivity
{
	/**
	 *  Estat de la pregunta.
	 *  0: Pagina de pregunta; 1: pagina de respondre; 2: respós.
	 */
	public int state = 0;

	/**
	 *	Pregunta actual.
	 */
	public int question = -1;

	/**
	 * Numero de la casella de la resposta correcta.
	 */
	public int correctAnswer = -1;

	/**
	 * Numero de la casella que el jugador ha seleccionat.
	 */
	public int selectedAnswer = -1;

	/**
	 * Int32 de 3 valors segons si s'ha respost be, malament o no a la preguta.
	 * -1: encara no contestat; 0: resposta incorrecta; 1: resposta correcta.
	 */
	public int didItGetItRight = -1;

	/**
	 * LinearLayout de la pantalla; n'hi han tres i totes estan centrades a la part inferior de la
	 * pantalla; per canviar de pagines.
	 */
	private LinearLayout linearLayoutPregunta, linearLayoutResposta, linearLayoutContinuar;

	/**
	 * ImageButtons de la taula. N'hi han 12, un per cada casella clickable.
	 */
	private ImageButton imageButton001, imageButton002, imageButton003, imageButton004,
						imageButton005, imageButton006, imageButton007, imageButton008,
						imageButton009, imageButton010, imageButton011, imageButton012;

	/**
	 * Els ImageButtons que estan en els LinearLayouts de la part inferior.
	 * Canvien de pagina o d'activitat.
	 */
	private ImageButton imageButtonPregunta, imageButtonResposta, imageButtonContinuar;

	/**
	 * Els diferents TextViews de la pantalla.
	 */
	private TextView textViewPregunta, textViewResposta, textViewTitle;

	/**
	 * L'imatge principal de la pantalla; que sols es mostra a la pagina de la pregunta.
	 */
	private ImageView imageView;

	/**
	 * El controlador de la taula a on els 12 ImageButtons estan.
	 */
	private TableLayout tableLayout;

	/**
	 * @param savedInstanceState If the activity is being re-initialized after
	 *                           previously being shut down then this Bundle contains the data it most
	 *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
	 */
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

	/**
	 * Canvia l'estat de la pregunta (la pagina). Es recomenable fer-ho desde aqui enlloc de
	 * settejar la variable directament perque al fer-ho desde aqui també canviem l'estat dels
	 * components segons correspongui.
	 * @param state El nou estat
	 */
	public void setState(int state)
	{
		this.state = state;
		changeComponentStates(state);
	}

	/**
	 * Segons l'estat actual; fa visibles o invisbles els components de la pantalla.
	 * @param state
	 */
	private void changeComponentStates(int state)
	{
		linearLayoutPregunta .setVisibility(View.GONE);
		linearLayoutResposta .setVisibility(View.GONE);
		linearLayoutContinuar.setVisibility(View.GONE);
		tableLayout			 .setVisibility(View.GONE);
		textViewTitle		 .setVisibility(View.GONE);
		imageView			 .setVisibility(View.GONE);
		switch(state)
		{
			case 0:
				linearLayoutPregunta .setVisibility(View.GONE);
				linearLayoutResposta .setVisibility(View.VISIBLE);
				linearLayoutContinuar.setVisibility(View.GONE);
				tableLayout			 .setVisibility(View.GONE);
				textViewTitle		 .setVisibility(View.VISIBLE);
				imageView			 .setVisibility(View.VISIBLE);
				break;
			case 1:
				linearLayoutPregunta .setVisibility(View.VISIBLE);
				linearLayoutResposta .setVisibility(View.GONE);
				linearLayoutContinuar.setVisibility(View.GONE);
				tableLayout			 .setVisibility(View.VISIBLE);
				textViewTitle		 .setVisibility(View.GONE);
				imageView			 .setVisibility(View.GONE);
				break;
			case 2:
				linearLayoutPregunta .setVisibility(View.GONE);
				linearLayoutResposta .setVisibility(View.GONE);
				linearLayoutContinuar.setVisibility(View.VISIBLE);
				tableLayout			 .setVisibility(View.VISIBLE);
				textViewTitle		 .setVisibility(View.GONE);
				imageView			 .setVisibility(View.GONE);
			break;
		}
	}

	/**
	 * Funció que identifica tots els components utilitzant els seus IDs.
	 * Normalment aixo ho posem en el onCreate directament; pero en aquesta pantalla, com que n'hi
	 * han tants; ho hem psoat en aquesta funció per fer el onCreate no tan llarg.
	 */
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

	/**
	 * Metode que s'executa en fer click al botó de "Veure Pregunta".
	 * Fa que es mostri la pagina de la pregunta amb l'imatge.
	 * @param v de vendetta
	 */
	public void imageButtonPreguntaOnClick(View v)
	{
		if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.StandardThin);
		setState(0);
	}

	/**
	 * Metode que s'executa en fer click al botó de "Veure Resposta".
	 * Fa que es mostri la pagina de la taula de botons.
	 * @param v Alguna cosa d'Android
	 */
	public void imageButtonRespostaOnClick(View v)
	{
		if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.StandardThin);
		setState(1);
	}

	/**
	 * Metode que s'executa en fer click al botó de "Continuar".
	 * Fa que es carregui la seguent pantalla.
	 */
	public void imageButtonContinuarOnClick()
	{
		if(AudioHolder.canPlaySFX) AudioHolder.PlaySfx(Sound.Standard);
		if(didItGetItRight==1) LogicSingleton.PushMoreScores(1,1);
		else LogicSingleton.PushMoreScores(0,1);
		Intent intent = new Intent(LogicSingleton.NextQuestion(PantallaBotonsImatge.this));
		startActivity(intent);
	}

	/**
	 * Metode genenic de quan es fa click en un ImaegButton de la taula.
	 * Tots els ImageButtons porten cap aquí.
	 * @param click El número del botó qeu s'ha pretat.
	 */
	public void answerCommonOnClick(int click)
	{
		if(state==1)
		{
			setState(2);
			selectedAnswer = click;
			highlightAnswers(true);
		}
	}

	/**
	 *
	 * @param highlight
	 */
	@SuppressWarnings("ConstantConditions")
	public void highlightAnswers(boolean highlight)
	{
		if(selectedAnswer!=-1 && selectedAnswer==correctAnswer) //Aqui dins hi entra si la resposta escollida es la correccta
		{
			didItGetItRight = 1;
			if(AudioHolder.canPlayOkKo) AudioHolder.PlaySfx(Sound.Warning);
			if(highlight) paintColourTableButton(selectedAnswer,true);
		}
		else if(selectedAnswer!=-1 && selectedAnswer!=correctAnswer) //Aqui dins hi entra si la resposta escoliida es incorrecta
		{
			didItGetItRight = 0;
			if(AudioHolder.canPlayOkKo) AudioHolder.PlaySfx(Sound.Quit);
			if(highlight)
			{
				paintColourTableButton(selectedAnswer,false);
				paintColourTableButton(correctAnswer,true);
			}
		}
	}

	/**
	 * Pinta la casella de la taula segons si s'ha respós bé o malament.
	 * @param column Columa del botó a pintar
	 * @param row Fila del botó a pintar
	 * @param correct Si es correcte o no (true: correcte, verd; false: incorrecte, vermell)
	 */
	@SuppressWarnings("unused")
	public void paintColourTableButton(int column, int row, boolean correct)
	{
		paintColourTableButton(column,row,correct,true);
	}

	/**
	 * Pinta la casella de la taula segons si s'ha respós bé o malament.
	 * @param column Columa del botó a pintar
	 * @param row Fila del botó a pintar
	 * @param correct Si es correcte o no (true: correcte, verd; false: incorrecte, vermell)
	 * @param startsAtZero Si es true, es comença a comptar desdel 0; de lo contrarí es compta desde l'1.
	 */
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

	/**
	 * Pinta la casella de la taula segons si s'ha respós bé o malament.
	 * @param num Número de la casella a pintar.
	 * @param correct Si es correcte o no (true: correcte, verd; false: incorrecte, vermell)
	 */
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

	/**
	 * Metode que es comunica amb el LogicSingleton i obté tota la informació de la pregunta i
	 * l'aplica o guarda a on correspongui.
	 * @param question La pregunta actual
	 */
	public void setThingsToQuestion(int question)
	{
		correctAnswer = Integer.parseInt(LogicSingleton.getCurrentQuestionInformation().answers[0]);
		textViewTitle.setText(LogicSingleton.getCurrentQuestionInformation().questionTitle);
		imageView.setImageResource(getResources().getIdentifier(LogicSingleton.getCurrentQuestionInformation().images[0],"drawable",getPackageName()));
	}
}