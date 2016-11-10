// Based on java version of this solution
// This works but is too slow to be accepted, need a smarter approach.

#include <stdio.h>  
#include <stdlib.h>  

int counter;

struct node {
    int data;
    struct node *left;
    struct node *right;
};

struct node* create_node(int data) {
  struct node* node = (struct node*)malloc(sizeof(struct node)); // Allocate memory for new node 
 
  node->data = data; // Assign data to this node
 
  // Initialize left and right children as NULL
  node->left = NULL;
  node->right = NULL;
  return(node);
}

int insert_node(struct node** root, int data) { // insert node in the "tree"
    struct node* new_node = create_node(data);
    
    if (*root == NULL) {
        *root = new_node;
        return counter;
    }
    struct node *current = *root;
    struct node *parent = NULL;
    while(1) {
        parent = current;
        counter++;
        if(data < current->data) {
            current = current->left;
            if(current == NULL) {
                parent->left = new_node;
                return counter;
            }
        } else {
            current = current->right;
            if(current == NULL) {
                parent->right = new_node;
                return counter;
            }
        }
    }
}

int main(void) {
    int nNodes, input;
    scanf("%d", &nNodes);
    
    struct node* root = NULL;
    counter = 0;
    
    for (int i = 0; i < nNodes; i++) {
        scanf("%d", &input);
        printf("%d\n", insert_node(&root, input));
    }
}