package com.kenny.engine.input;

import org.lwjgl.glfw.GLFW;

import com.kenny.engine.EngineWindow;

public class Keyboard 
{
	/**Массив всех доступных клавиш в ACSII таблице / кодировке.*/
	private static boolean[] keys = new boolean[GLFW.GLFW_KEY_LAST];
	
	/**
	 * Возврашает true в том случае, если клавиша нажата/удержена. Я забыл сказать в
	 * видео что этот метод можно назвать keyHold() так как если удерживать кнопку, он всё
	 * равно вернёт true.
	 */
	public static boolean keyDown(int keyId)
	{
		return GLFW.glfwGetKey(EngineWindow.getWindow().id, keyId) == 1;
	}
	
	/**
	 * Возврашает true в том случае, если клавиша нажата, иначе возврашет false.
	 */
	 public static boolean keyPreesed(int keyId)
	{
		return keyDown(keyId) && !keys[keyId];
	}
	
	/**
	 * Возврашает true в том случае, если клавиша отпушена, иначе возврашет false.
	 */
	public static boolean keyReleased(int keyId)
	{
		return !keyDown(keyId) && keys[keyId];
	}
	
	/**
	 * Удерживает весь ввод с вашей клавиатуры.
	 */
	public static void handleKeyboardInput()
	{
		//выполняет это действие для каждой доступной клавишы
		for (int i = 0; i < GLFW.GLFW_KEY_LAST; i++) 
		{
			keys[i] = keyDown(i);
		}
	}
}
