package com.kenny.engine;

import org.lwjgl.glfw.GLFW;

import com.kenny.engine.input.Keyboard;

public class Engine 
{
	public static final int WIDHT = 640;
	public static final int HEIGHT = 360;
	public static final String TITLE = "Engine 0.0.1 pre-alpha";
	private EngineWindow engineWindow;
	
	public void run() 
	{
		this.init();
	}
	
	public void init() 
	{
		this.engineWindow = new EngineWindow(WIDHT, HEIGHT, TITLE);
		this.engineWindow.create();
		this.update();
	}
	
	public void update() 
	{
		while(!this.engineWindow.isCloseRequest())
		{
			if(Keyboard.keyPreesed(GLFW.GLFW_KEY_A))
			{
				System.out.println("Клавиша А нажата!");
			}
			else if(Keyboard.keyReleased(GLFW.GLFW_KEY_A))
			{
				System.out.println("Клавиша А отпушена!");
			}
			
			//удерживает ввод с клавиатуры
			Keyboard.handleKeyboardInput();
			this.engineWindow.update();
			
			// render pass (рендеринг)
		}
		
		this.engineWindow.destroy();
	}

	public EngineWindow getEngineWindow() 
	{
		return this.engineWindow;
	}
	
}
