
// Implementation of a dictionary using a hash table

#include <stdlib.h>
#include <string.h>
#include "hash-dictionary.h"
#include <stdio.h>
// Constructor
HashDictionary::HashDictionary()
{
	_buckets = new HashNode*[MaxBuckets];
	for(int i = 0; i < MaxBuckets; i++) {
		_buckets[i] = NULL;
	}
}

int
HashDictionary::hash(KeyType key) {
	int hash = 0;
	for(int i = 0; i < strlen(key); i++) {
		hash += key[i];
	}
	return hash % MaxBuckets;
}

// Add a record to the dictionary. Returns false if key already exists
bool
HashDictionary::addRecord( KeyType key, DataType record)
{
	int h = hash(key);
	HashNode *e = _buckets[h];
	while(e!=NULL) {
		if(!strcmp(e->_key, key)) {
			e->_data = record;
			return false;
		}
		e = e->_next;
	}
	e = new HashNode;
	e->_key = strdup(key);
	e->_data = record;
	e->_next = _buckets[h];
	_buckets[h] = e;
	nElements++;
	return true;
}


// Find a key in the dictionary and return corresponding record or NULL
DataType
HashDictionary::findRecord( KeyType key)
{
	int h = hash(key);
	HashNode *e = _buckets[h];
	while(e != NULL) {
		if(!strcmp(e->_key, key)) {
//			printf("now giving %d", long(e->_data));
			return e->_data;
		}
		e = e->_next;
	}
	return NULL;
}

// Removes one element from the table
bool
HashDictionary::removeElement(KeyType key)
{
	int h = hash(key);
	HashNode *e = _buckets[h];
	HashNode *p = e;
	if(e == NULL)
		return false;
	if(!strcmp(e->_key, key)) {
		_buckets[h] = _buckets[h]->_next;
		delete e;
		return true;
	}
	e = e->_next;
	while(e != NULL) {
		if(!strcmp(e->_key, key)) {
			p->_next = e->_next;
			delete e;
			return true;
		}
		p = e;
		e = e->_next;
	}
	return false;
}

// Returns all the elements in the table as an array of strings.
// *n is the size of the table and it is returned by reference
KeyType *
HashDictionary::keys(int * n)
{
	KeyType * a = (KeyType *) malloc(nElements * sizeof(KeyType));

	*n = nElements;
	int i = 0;
	for (int h = 0; h < MaxBuckets; h++) {
		HashNode * n = _buckets[h];
		while (n!=NULL) {
			a[i] = n->_key;
			i++;
			n = n->_next;
		}
	}
	*n = nElements;
	return a;
}

