package com.muhammeteminbaytar.survivorbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class SurvivorBird extends ApplicationAdapter {



	SpriteBatch batch;
	Texture background;
	Texture background2;
	Texture kaktus4;
	Texture kaktus3;
	Texture kaktus2;
	Texture kaktus;

	Texture medal1;
	Texture medal2;
	Texture medal3;
	Texture medal4;


    Texture[] immageArray;
    Texture[] engelArray;
    Texture[] yesilArray;
    Texture[] pembeArray;

    Circle birdCircle;

    Circle enemyCircle;
	Circle enemyCircle2;
	Circle enemyCircle3;
	Circle medalCircle1;
	Circle medalCircle2;
	Circle medalCircle3;
	Circle medalCircle4;
	Circle VoiceCircle;


	Rectangle treeCircle;
	Rectangle treeCircle2;
	Rectangle treeCircle3;
	Rectangle treeCircle4;



    ShapeRenderer shapeRenderer;




	Texture bird;
	Texture bird2;
	Texture bird3;





	Texture engel1;
	Texture engel2;
	Texture engel3;
	Texture engel4;

	Texture yesilEngel;
	Texture yesilEngel2;
	Texture yesilEngel3;
	Texture yesilEngel4;

	Texture pembeEngel;
	Texture pembeEngel2;
	Texture pembeEngel3;
	Texture pembeEngel4;

	Texture zemin1;
	Texture zemin2;

	Texture tap1;
	Texture tap2;
	Texture[] tapArray;
	Texture tap3;
	Texture gameOver;
	Texture getReady;


	Preferences preferences;







Random rnd =new Random();

	float birdX=0;
	float birdY=0;
	int gameState=0;
	float volacity=0;

	float enemyX;
	float enemyX2;
	float enemyX3;
	float enemyX4;




	float engelX;
	float engelY;
	float yesilEngelX;
	float yesilEngelY;
	float pembeEngelX;
	float pembeEngelY;




	float medal1y;
	float medal2y;
	float medal3y;
	float medal4y;

	int	i=0;
	int j=0;
	int k=0;
	int z=0;
	int f=0;


	float zeminX;
	float zemin2X;
	int sayac=0;


	BitmapFont font;//ekrana anlık scoru yazar
    BitmapFont bestScor;



    private Sound coinSound;
    private Music music;
    private Sound crashSound;
    boolean crashStart=true;

	static float gravity;






	@Override
	public void create () {

	    preferences=Gdx.app.getPreferences("MyPreferces");


	    if(!preferences.contains("BestScor"))
	    {
	        preferences.putInteger("BestScor",0);

        }


		gravity=Gdx.graphics.getHeight()/1350f;


		music=Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        coinSound=Gdx.audio.newSound(Gdx.files.internal("coinSound.mp3"));
        crashSound=Gdx.audio.newSound(Gdx.files.internal("crash.mp3"));

        music.setLooping(true);
        music.setVolume(1);



		i=0;
		batch=new SpriteBatch();
        background=new Texture("background.png");
        background2=new Texture("background.png");
        bird=new Texture("bird.png");
        bird2=new Texture("bird2.png");
        bird3=new Texture("bird3.png");


        VoiceCircle=new Circle();

        birdCircle=new Circle();

        enemyCircle=new Circle();
        enemyCircle2=new Circle();
		enemyCircle3=new Circle();


		treeCircle = new Rectangle();
		treeCircle2=new Rectangle();
		treeCircle3=new Rectangle();
		treeCircle4=new Rectangle();

		medalCircle1=new Circle();
		medalCircle2=new Circle();
		medalCircle3=new Circle();
		medalCircle4=new Circle();

        shapeRenderer=new ShapeRenderer();

        font=new BitmapFont();
        bestScor=new BitmapFont();


        font.setColor(Color.FIREBRICK);
        font.getData().scale(Gdx.graphics.getWidth()/400);
       font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        bestScor.setColor(Color.FIREBRICK);
        bestScor.getData().scale(Gdx.graphics.getWidth()/400);
        bestScor.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);






        zemin1=new Texture("zemin.png");
        zemin2=new Texture("zemin.png");
        immageArray = new Texture[]{bird,bird2,bird3};

    //    bee1=new Texture("enemy.png");
        kaktus=new Texture("tree1.png");
		kaktus2=new Texture("tree2.png");
		kaktus3=new Texture("tree3.png");
		kaktus4=new Texture("tree4.png");

		medal1=new Texture("medal1.png");
		medal2=new Texture("bronze.png");
		medal3=new Texture("silver.png");
		medal4=new Texture("bronze.png");


		engel1=new Texture("engel1.png");
		engel2=new Texture("engel2.png");
		engel3=new Texture("engel3.png");
		engel4=new Texture("engel4.png");

		engelArray=new Texture[]{engel1,engel2,engel3,engel4};

		yesilEngel=new Texture("yesilEngel.png");
		yesilEngel2=new Texture("yesilEngel2.png");
		yesilEngel3=new Texture("yesilEngel3.png");
		yesilEngel4=new Texture("yesilEngel4.png");
		yesilArray=new Texture[]{yesilEngel,yesilEngel2,yesilEngel3,yesilEngel4};

       pembeEngel=new Texture("pembeEngel.png");
       pembeEngel2=new Texture("pembeEngel2.png");
		pembeEngel3=new Texture("pembeEngel3.png");
		pembeEngel4=new Texture("pembeEngel4.png");



       pembeArray=new Texture[]{pembeEngel,pembeEngel2,pembeEngel3,pembeEngel4};

        birdX=Gdx.graphics.getWidth()/5;
        birdY=Gdx.graphics.getHeight()/2;



        enemyX=Gdx.graphics.getWidth()+250;
        enemyX2=enemyX+Gdx.graphics.getWidth()/3;
		enemyX3=enemyX2+Gdx.graphics.getWidth()/3;
		enemyX4=enemyX3+Gdx.graphics.getWidth()/3;





		medal1y=rnd.nextFloat()*Gdx.graphics.getHeight()/1.5f;
		medal2y=rnd.nextFloat()*Gdx.graphics.getHeight()/1.5f;
		medal3y=rnd.nextFloat()*Gdx.graphics.getHeight()/1.5f;
		medal4y=rnd.nextFloat()*Gdx.graphics.getHeight()/1.5f;

		engelX=Gdx.graphics.getWidth()+Gdx.graphics.getWidth()/6;
		engelY=rnd.nextFloat()*Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/3.5f;

		yesilEngelX=engelX+Gdx.graphics.getWidth()/2;
		yesilEngelY=rnd.nextFloat()*Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/3.5f;

		pembeEngelX=yesilEngelX+Gdx.graphics.getWidth()/2;
		pembeEngelY=rnd.nextFloat()*Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/3.5f;




		zeminX=0;
		zemin2X=Gdx.graphics.getWidth();

		tap1=new Texture("tap1.png");
		tap2=new Texture("tap2.png");
		tapArray=new Texture[]{tap1,tap2};
		tap3=new Texture("tap3.png");
		gameOver=new Texture("gameOver.png");
		getReady=new Texture("getReady.png");


	}


	@Override
	public void render () {


		batch.begin();





		zeminX=zeminX-Gdx.graphics.getWidth()/260;
		zemin2X=zemin2X-Gdx.graphics.getWidth()/260;
		if (zemin2X<0){
			zeminX=zemin2X+Gdx.graphics.getWidth();
		}
		if(zeminX<0){
			zemin2X=zeminX+Gdx.graphics.getWidth();
		}




		if (gameState == 1) {

          crashStart=true;

			music.play();




			birdCircle.set(birdX+Gdx.graphics.getWidth()/28,birdY+Gdx.graphics.getHeight()/15,Gdx.graphics.getWidth()/34);

			batch.draw(background,zeminX,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
            batch.draw(background2,zemin2X,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
            batch.draw(zemin1,zeminX,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/5);
            batch.draw(zemin2,zemin2X,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/5);
            batch.draw(immageArray[i],birdX,birdY,Gdx.graphics.getWidth()/14,Gdx.graphics.getHeight()/9);

			if(zeminX%3==0) {
				if (i < 4) {
					i++;
					if (i == 3) {
						i = 0;
					}

				}
			}

			batch.draw(kaktus, enemyX-Gdx.graphics.getWidth()/8, 0, Gdx.graphics.getWidth() / 12, Gdx.graphics.getHeight()/3.5f);
			batch.draw(kaktus2, enemyX2-Gdx.graphics.getWidth()/8,0, Gdx.graphics.getWidth() / 12, Gdx.graphics.getHeight()/3.5f);
			batch.draw(kaktus3, enemyX3-Gdx.graphics.getWidth()/8, 0, Gdx.graphics.getWidth() / 12, Gdx.graphics.getHeight()/3.5f);
			batch.draw(kaktus4, enemyX4-Gdx.graphics.getWidth()/8, 0, Gdx.graphics.getWidth() / 12, Gdx.graphics.getHeight()/3.5f);


			font.draw(batch,String.valueOf(sayac),Gdx.graphics.getWidth()/35,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/18);

			batch.draw(medal1,enemyX-Gdx.graphics.getWidth()/3.5f,medal1y,Gdx.graphics.getWidth()/13,Gdx.graphics.getWidth()/13);
            batch.draw(medal2,enemyX2-Gdx.graphics.getWidth()/3.5f,medal2y,Gdx.graphics.getWidth()/13,Gdx.graphics.getWidth()/13);
			batch.draw(medal3,enemyX3-Gdx.graphics.getWidth()/3.5f,medal3y,Gdx.graphics.getWidth()/13,Gdx.graphics.getWidth()/13);
			batch.draw(medal4,enemyX4-Gdx.graphics.getWidth()/3.5f,medal4y,Gdx.graphics.getWidth()/13,Gdx.graphics.getWidth()/13);

			if(zeminX%3==0){
			if(j<4){
				j++;
				if(j==4){j=0;}

			}}
            if(enemyX-Gdx.graphics.getWidth()/4.5f<0)
            {
            	medal1y=rnd.nextFloat()*Gdx.graphics.getHeight()/1.5f;

			}
            if (enemyX2-Gdx.graphics.getWidth()/4.5f<0){
				medal2y=rnd.nextFloat()*Gdx.graphics.getHeight()/1.5f;
			}
            if(enemyX3-Gdx.graphics.getWidth()/4.5f<0){
				medal3y=rnd.nextFloat()*Gdx.graphics.getHeight()/1.5f;
			}
            if(enemyX4-Gdx.graphics.getWidth()/4.5f<0){
				medal4y=rnd.nextFloat()*Gdx.graphics.getHeight()/1.5f;
			}


            batch.draw(engelArray[j],engelX-Gdx.graphics.getWidth()/8,engelY,Gdx.graphics.getWidth()/14,Gdx.graphics.getHeight()/9);



			engelX=engelX-2*Gdx.graphics.getWidth()/260;

			if(engelX<0){
			    engelX=pembeEngelX+Gdx.graphics.getWidth()/2;

				engelY=rnd.nextFloat()*Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/3;
            }

			batch.draw(yesilArray[k],yesilEngelX-Gdx.graphics.getWidth()/8,yesilEngelY,Gdx.graphics.getWidth()/14,Gdx.graphics.getHeight()/9);

			if(zeminX%3==0){
			if (k<4){
				k++;
				if(k==4){k=0;}
			}}
			yesilEngelX=yesilEngelX-2*Gdx.graphics.getWidth()/260;
			if(yesilEngelX<0){

				yesilEngelX=engelX+Gdx.graphics.getWidth()/2;

                yesilEngelY=rnd.nextFloat()*Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/3.5f;

			}

			batch.draw(pembeArray[z],pembeEngelX-Gdx.graphics.getWidth()/8,pembeEngelY,Gdx.graphics.getWidth()/14,Gdx.graphics.getHeight()/9);

			if(zeminX%3==0){
			if(z<4){
				z++;
				if(z==4){z=0;}
			}}

			pembeEngelX=pembeEngelX-2*Gdx.graphics.getWidth()/260;

			if(pembeEngelX<0){

				pembeEngelX=yesilEngelX+Gdx.graphics.getWidth()/2;
				pembeEngelY=rnd.nextFloat()*Gdx.graphics.getHeight()/2+Gdx.graphics.getHeight()/3;
			}

             enemyX=enemyX-Gdx.graphics.getWidth()/260;
             enemyX2=enemyX2-Gdx.graphics.getWidth()/260;
             enemyX3=enemyX3-Gdx.graphics.getWidth()/260;
             enemyX4=enemyX4-Gdx.graphics.getWidth()/260;
           if(enemyX<0){

           	enemyX=enemyX4+Gdx.graphics.getWidth()/3;

		   }
           if(enemyX2<0){

           	enemyX2=enemyX+Gdx.graphics.getWidth()/3;
		   }
           if(enemyX3<0){

			   enemyX3=enemyX2+Gdx.graphics.getWidth()/3;
		   }
			if(enemyX4<0){

				enemyX4=enemyX3+Gdx.graphics.getWidth()/3;
			}

			//    }
            //	batch.draw(bee1,enemyX,150,Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/8);
		//	batch.draw(bee1,enemyX,250,Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/8);
		//	batch.draw(bee1,enemyX,350,Gdx.graphics.getWidth()/10,Gdx.graphics.getHeight()/8);



			if (Gdx.input.justTouched()) {
				volacity=-Gdx.graphics.getHeight()/65f;

			}

			if (birdY > 0||volacity<0) {
				volacity = volacity + gravity;
				birdY = birdY - volacity;

			}
		} else if(gameState==0) {
			birdCircle.set(birdX+Gdx.graphics.getWidth()/28,birdY+Gdx.graphics.getHeight()/15,Gdx.graphics.getWidth()/34);


			font.draw(batch,String.valueOf(sayac),Gdx.graphics.getWidth()/35,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/18);


			batch.draw(background,zeminX,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			batch.draw(background2,zemin2X,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			batch.draw(zemin1,zeminX,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/5);
			batch.draw(zemin2,zemin2X,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/5);
			batch.draw(immageArray[i],birdX,birdY,Gdx.graphics.getWidth()/14,Gdx.graphics.getHeight()/9);

			batch.draw(tapArray[f],Gdx.graphics.getWidth()/2.2f,Gdx.graphics.getHeight()/8,Gdx.graphics.getWidth()/12,Gdx.graphics.getHeight()/6);

			batch.draw(getReady,Gdx.graphics.getWidth()/5,Gdx.graphics.getHeight()/1.4f,Gdx.graphics.getWidth()/1.7f,Gdx.graphics.getHeight()/7);

			bestScor.setColor(Color.FIREBRICK);
			bestScor.draw(batch,String.valueOf("Best Score:"+preferences.getInteger("BestScor")),Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/2);

			if(zeminX%13==0)
			{
				if(f<2)
				{
					f++;
					if(f==2)f=0;
				}
			}
			if(zeminX%3==0) {
				if (i < 4) {
					i++;
					if (i == 3) {
						i = 0;
					}

				}
			}

			music.play();


			if (Gdx.input.justTouched()) {
				gameState = 1;



			}
		}
		else if(gameState==2)
		{

            if(sayac>preferences.getInteger("BestScor"))//yeni best scoru kaydeder
            {
                preferences.putInteger("BestScor",sayac);
                preferences.flush();
            }

			batch.draw(background,zeminX,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			batch.draw(background2,zemin2X,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
			batch.draw(zemin1,zeminX,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/5);
			batch.draw(zemin2,zemin2X,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/5);
			batch.draw(immageArray[i],birdX,birdY,Gdx.graphics.getWidth()/14,Gdx.graphics.getHeight()/9);
			zeminX=zeminX+Gdx.graphics.getWidth()/260;
		    zemin2X=zemin2X+Gdx.graphics.getWidth()/260;
		    batch.draw(tap3,Gdx.graphics.getWidth()/2.7f,Gdx.graphics.getHeight()/7,Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/7);
            batch.draw(gameOver,Gdx.graphics.getWidth()/5,Gdx.graphics.getHeight()/1.4f,Gdx.graphics.getWidth()/1.7f,Gdx.graphics.getHeight()/7);

			font.setColor(Color.FOREST);
			font.draw(batch,String.valueOf("Score:"+sayac),Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/2.5f);

			bestScor.draw(batch,String.valueOf("Best Score:"+preferences.getInteger("BestScor")),Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/1.8f);


            music.pause();
			if (Gdx.input.justTouched()) {
				sayac=0;
				music.stop();
				gameState = 0;
				birdY=Gdx.graphics.getHeight()/2;

				enemyX=Gdx.graphics.getWidth()+260;
				enemyX2=enemyX+Gdx.graphics.getWidth()/3;
				enemyX3=enemyX2+Gdx.graphics.getWidth()/3;
				enemyX4=enemyX3+Gdx.graphics.getWidth()/3;
				engelX=Gdx.graphics.getWidth()+Gdx.graphics.getWidth()/6;
				yesilEngelX=engelX+Gdx.graphics.getWidth()/2;
				pembeEngelX=yesilEngelX+Gdx.graphics.getWidth()/2;
				zeminX=0;
				zemin2X=Gdx.graphics.getWidth();
			}

		}





     batch.end();


		enemyCircle.set(engelX-Gdx.graphics.getWidth()/8+Gdx.graphics.getWidth()/28,engelY+Gdx.graphics.getHeight()/17,Gdx.graphics.getWidth()/40);

		enemyCircle2.set(yesilEngelX-Gdx.graphics.getWidth()/8+Gdx.graphics.getWidth()/28,yesilEngelY+Gdx.graphics.getHeight()/17,Gdx.graphics.getWidth()/40);

		enemyCircle3.set(pembeEngelX-Gdx.graphics.getWidth()/8+Gdx.graphics.getWidth()/28,pembeEngelY+Gdx.graphics.getHeight()/17,Gdx.graphics.getWidth()/40);

		treeCircle.set(enemyX-Gdx.graphics.getWidth()/9,Gdx.graphics.getHeight()/17,Gdx.graphics.getWidth()/17,Gdx.graphics.getHeight()/5);
		treeCircle2.set(enemyX2-Gdx.graphics.getWidth()/9,Gdx.graphics.getHeight()/17,Gdx.graphics.getWidth()/17,Gdx.graphics.getHeight()/5);
		treeCircle3.set(enemyX3-Gdx.graphics.getWidth()/9, Gdx.graphics.getHeight()/17,Gdx.graphics.getWidth()/17,Gdx.graphics.getHeight()/5);
		treeCircle4.set(enemyX4-Gdx.graphics.getWidth()/9, Gdx.graphics.getHeight()/17,Gdx.graphics.getWidth()/17,Gdx.graphics.getHeight()/5);

		medalCircle1.set(enemyX-Gdx.graphics.getWidth()/3.5f+Gdx.graphics.getWidth()/25,medal1y+Gdx.graphics.getHeight()/14,Gdx.graphics.getWidth()/28);
		medalCircle2.set(enemyX2-Gdx.graphics.getWidth()/3.5f+Gdx.graphics.getWidth()/25,medal2y+Gdx.graphics.getHeight()/14,Gdx.graphics.getWidth()/28);
		medalCircle3.set(enemyX3-Gdx.graphics.getWidth()/3.5f+Gdx.graphics.getWidth()/25,medal3y+Gdx.graphics.getHeight()/14,Gdx.graphics.getWidth()/28);
		medalCircle4.set(enemyX4-Gdx.graphics.getWidth()/3.5f+Gdx.graphics.getWidth()/25,medal4y+Gdx.graphics.getHeight()/14,Gdx.graphics.getWidth()/28);
		if(Intersector.overlaps(birdCircle,enemyCircle)||Intersector.overlaps(birdCircle,enemyCircle2)||Intersector.overlaps(birdCircle,enemyCircle3)||Intersector.overlaps(birdCircle,treeCircle)||Intersector.overlaps(birdCircle,treeCircle2)||Intersector.overlaps(birdCircle,treeCircle3)||Intersector.overlaps(birdCircle,treeCircle4)||birdY>Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/18)
		{
			if(crashStart==true)
			{
				crashSound.play(0.25f);
			}
			crashStart=false;
			gameState=2;
		}





		if(Intersector.overlaps(birdCircle,medalCircle1))
		{

			medal1y=Gdx.graphics.getHeight()+Gdx.graphics.getHeight()/2;
			sayac=sayac+150;
			coinSound.play();
		}
		if(Intersector.overlaps(birdCircle,medalCircle2))
		{

			medal2y=Gdx.graphics.getHeight()+Gdx.graphics.getHeight()/2;
			sayac=sayac+50;
			coinSound.play();
		}
		if(Intersector.overlaps(birdCircle,medalCircle3))
		{

			medal3y=Gdx.graphics.getHeight()+Gdx.graphics.getHeight()/2;
			sayac=sayac+100;
			coinSound.play();
		}


		if(Intersector.overlaps(birdCircle,medalCircle4))
		{

			medal4y=Gdx.graphics.getHeight()+Gdx.graphics.getHeight()/2;
			sayac=sayac+50;
			coinSound.play();
		}
		if(birdY<0){birdY=0;}








/*
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		shapeRenderer.setColor(Color.PURPLE);

		shapeRenderer.circle(birdCircle.x,birdCircle.y,birdCircle.radius);
		shapeRenderer.circle(enemyCircle.x,enemyCircle.y,enemyCircle.radius);
		shapeRenderer.circle(enemyCircle3.x,enemyCircle3.y,enemyCircle3.radius);
		shapeRenderer.circle(enemyCircle2.x,enemyCircle2.y,enemyCircle2.radius);

		shapeRenderer.circle(medalCircle1.x,medalCircle1.y,medalCircle1.radius);
		shapeRenderer.circle(medalCircle2.x,medalCircle2.y,medalCircle2.radius);
		shapeRenderer.circle(medalCircle3.x,medalCircle3.y,medalCircle3.radius);
		shapeRenderer.circle(medalCircle4.x,medalCircle4.y,medalCircle4.radius);

		//shapeRenderer.circle(VoiceCircle.x,VoiceCircle.y,VoiceCircle.radius);


		shapeRenderer.rect(treeCircle.x,treeCircle.y,treeCircle.width,treeCircle.height);
		shapeRenderer.rect(treeCircle2.x,treeCircle2.y,treeCircle2.width,treeCircle2.height);
		shapeRenderer.rect(treeCircle3.x,treeCircle3.y,treeCircle3.width,treeCircle3.height);
		shapeRenderer.rect(treeCircle4.x,treeCircle4.y,treeCircle4.width,treeCircle4.height);
		shapeRenderer.end();
*/

}
	
	@Override
	public void dispose () {

	}


}
