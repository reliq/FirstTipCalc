/**
 * Copyright (c) 2014 Michal Dabski
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * Copyright 2014 ReliQ Artz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.reliqartz.firsttipcalc.utils;

import android.view.View;
import android.view.ViewGroup;

/***
 * Traverse layout tree one view at a time
 * @author Michal
 */
public class ViewTraverser {
		
	private final View root;
	
	public ViewTraverser(View root)
	{
		this.root = root;
	}
	
	public void traverse(ForeachAction<View> foreach)
	{
		traverse(root, foreach);
	}
	
	protected void traverse(View root, ForeachAction<View> foreach)
	{
		foreach.onElement(root);
		if (root instanceof ViewGroup)
		{
			ViewGroup viewGroup = (ViewGroup) root;
			for (int i = 0; i < viewGroup.getChildCount(); i++)
			{
				traverse(viewGroup.getChildAt(i), foreach);
			}
		}
	}
	
	/**
	 * Action to be performed on each object.
	 * @author Michal
	 * @param <T>
	 */
	public interface ForeachAction<T> {
		void onElement(T element);
	}
}
