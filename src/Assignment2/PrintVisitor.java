public class PrintVisitor implements CCALParserVisitor {

    public Object visit(SimpleNode node, Object data){
        throw new RuntimeException("Visit SimpleNode");
    }

    public Object visit(ASTProgram node, Object data){
        node.jjtGetChild(0).jjtAccept(this, data);
        node.jjtGetChild(1).jjtAccept(this, data);
        node.jjtGetChild(2).jjtAccept(this, data);
        System.out.println("END OF PROGRAM");
        return (data);
    }

    //Write rest of the methods in alphabetical order

    public Object visit(ASTArgList node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTBinaryArithOp node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTCompOp node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTCondition node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTConditionAlpha node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTConditionBeta node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTConditionPrime node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTConstDecl node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTDecl node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTDeclList node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTExpression node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTExpressionAlpha node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTExpressionBeta node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTFragment node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTFragmentDelta node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTFragmentPrime node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTFunction node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTFunctionList node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTID node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTMain node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTNempArgList node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTNempArgListPrime node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTNempParameterList node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTNempParamterListPrime node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTNum node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTParameterList node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTStatement node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTStatementBlock node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTStatementPrime node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTType node, Object data){
        System.out.println(node.value);
        return (data);
    }

    public Object visit(ASTVarDecl node, Object data){
        System.out.println(node.value);
        return (data);
    }


}
