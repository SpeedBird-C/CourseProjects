
// Implementation of a dictionary using an array and sequential search
// The array will be dynamically resized if necessary

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "array-dictionary.h"

// Constructor
ArrayDictionary::ArrayDictionary()
{
	maxNumber = 1024; // set default to be 1024
	array = new ArrayDictionaryNode* [maxNumber];
	currentNumber = 0;
}

// Add a record to the dictionary. Returns false if key already exists
bool
ArrayDictionary::addRecord( KeyType key, DataType record)
{
//	printf("ADDED ONCE %s\n", key);
        // Add your code here
	for(int i = 0; i < currentNumber; i++) {
		if(!strcmp(key, array[i]->key)) {
			array[i]->data = record;
			return false;
		}
	}
	if(currentNumber >= maxNumber) {
		int newMaxNumber = maxNumber * 2;
		ArrayDictionaryNode **newArray;
		newArray = new ArrayDictionaryNode* [newMaxNumber];
		for(int i = 0; i < maxNumber; i++) {
			newArray[i] = array[i];
		}
		delete array;
		maxNumber = newMaxNumber;
		array = newArray;
	}
	array[currentNumber] = new ArrayDictionaryNode;
	array[currentNumber]->key = strdup((char*)key);
	array[currentNumber]->data = record;
//	printf("added:%s\n%s\n", array[currentNumber]->key, (char*)array[currentNumber]->data);
	currentNumber++;
	return true;
}

// Find a key in the dictionary and return corresponding record or NULL
DataType
ArrayDictionary::findRecord( KeyType key)
{
        // add your code here
	for(int i = 0; i < currentNumber; i++) {
		if(!strcmp(key, (char*)array[i]->key)) {
			return array[i]->data;
		}
	}
	return NULL;
}

// Removes one element from the table
bool
ArrayDictionary::removeElement(KeyType key)
{
        // Add your code here
	for(int i = 0; i < currentNumber; i++) {
		if(!strcmp(key, array[i]->key)) {
			delete array[i];
			for(int j = i; j < currentNumber - 1; j++) {
				array[j] = array[j+1];
			}
			delete array[currentNumber - 1];
			currentNumber--;
			return true;
		}
	}
	return false;
	
}

// Returns all the elements in the table as an array of strings.
// *n is the size of the table and it is returned by reference
KeyType *
ArrayDictionary::keys(int * n)
{
	KeyType * s = new KeyType[currentNumber];
	for(int i = 0 ; i < currentNumber; i++)
		s[i] = strdup(array[i]->key);
	*n = currentNumber;
	return s;
}

