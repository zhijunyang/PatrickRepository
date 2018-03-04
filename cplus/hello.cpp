#include <iostream>

using namespace std;
struct BinaryTreeNode {
    BinaryTreeNode *m_pRight;
    BinaryTreeNode *m_pLeft;
    BinaryTreeNode *m_pParent;
    char value;
    BinaryTreeNode* AddLeftNode(char value)
    {
        BinaryTreeNode* left = new BinaryTreeNode();
        left->m_pParent = this;
        left->value = value;
        left->m_pLeft = NULL;
        left->m_pRight = NULL;
        this->m_pLeft = left;
        return left;
    }

    BinaryTreeNode* AddRightNode(int value)
    {
        BinaryTreeNode* right = new BinaryTreeNode();
        right->m_pParent = this;
        right->value = value;
        right->m_pLeft = NULL;
        right->m_pRight = NULL;
        this->m_pRight = right;
        return right;
    }
};


BinaryTreeNode* BuildTree()
{
    BinaryTreeNode* root = new BinaryTreeNode();
    BinaryTreeNode *left, *right, *temp;
    root->m_pParent = NULL;
    root->value = 'a';
    left = root->AddLeftNode('b');
    temp = right = root->AddRightNode('c');
    left->AddLeftNode('d');
    right = left->AddRightNode('e');
    right->AddLeftNode('h');
    right->AddRightNode('i');
    temp->AddLeftNode('f');
    temp->AddRightNode('g');
    return root;
}

void PrintInOrder(BinaryTreeNode* pNode)
{
    if (pNode == NULL)
        return;

    PrintInOrder(pNode->m_pLeft);
    cout << pNode->value << endl;
    PrintInOrder(pNode->m_pRight);
}

void PrintPreOrder(BinaryTreeNode* pNode)
{
    if (pNode == NULL)
        return;

    cout << pNode->value << endl;   
    PrintPreOrder(pNode->m_pLeft);
    
    PrintPreOrder(pNode->m_pRight);
}

void PrintPostOrder(BinaryTreeNode* pNode)
{
    if (pNode == NULL)
        return;

     
    PrintPostOrder(pNode->m_pLeft);
    
    PrintPostOrder(pNode->m_pRight);

    cout << pNode->value << endl;  
}

BinaryTreeNode* GetNext(BinaryTreeNode* pNode) {
    if (pNode == NULL)
        return NULL;

    BinaryTreeNode *pNext = NULL;
    if (pNode->m_pRight != NULL)
    {
        BinaryTreeNode *pRight = pNode->m_pRight;
        while(pRight->m_pLeft != NULL)
        {
            pRight = pRight->m_pLeft;

        }

        pNext = pRight;
    }
    else if (pNode->m_pParent != NULL)
    {
        BinaryTreeNode *pCurrent = pNode;
        BinaryTreeNode *pParent = pNode->m_pParent;
        while(pParent != NULL && pCurrent== pParent->m_pRight)
        {
            pCurrent = pParent;
            pParent = pParent->m_pParent;
        }

        pNext = pParent;
    }

    return pNext;
}

int main()
{
    cout << "hello" << endl;
    BinaryTreeNode *root = BuildTree();
    BinaryTreeNode * temp = GetNext(root->m_pLeft->m_pRight->m_pRight);
    cout << "inorder" << endl;
    PrintInOrder(root);
    cout << "postorder" << endl;
    PrintPostOrder(root);
    cout << "preroder" << endl;
    PrintPreOrder(root);
    return 0;
}


