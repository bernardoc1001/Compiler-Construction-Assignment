import java.util.*;

public class TypeCheckVisitor implements CCALParserVisitor {

    private static Object getDataType(SimpleNode node, Object data){
        SymbolTable ST = (SymbolTable) data;
        STC hashTableEntry;

        hashTableEntry = ST.getStcFromScope((String) node.value);
        if(hashTableEntry == null){
            System.out.println("Error: " + (String) node.value + " not found in scope. Returning typeUnknown");
            return DataType.TypeUnknown;
        }
        else if(Objects.equals(hashTableEntry.type, "integer")){
            System.out.println("Returning TypeInteger");
            return DataType.TypeInteger;
        }
        else if(Objects.equals(hashTableEntry.type, "boolean")){
            System.out.println("Returning TypeBoolean");
            return DataType.TypeBoolean;
        }
        else if(Objects.equals(hashTableEntry.type, "void")){
            System.out.println("Returning TypeVoid");
            return DataType.TypeVoid;
        }
        else{
            System.out.println("Returning TypeUnknown");
            return DataType.TypeUnknown;
        }
    }

    @Override
    public Object visit(SimpleNode node, Object data){
        throw new RuntimeException("Visit SimpleNode");
    }

    @Override
    public Object visit(ASTProgram node, Object data){
        //System.out.println("Start of program visitor");
        node.childrenAccept(this, data);
        System.out.println("END OF PROGRAM");
        return (DataType.Program);
    }

    //Write rest of the methods in alphabetical order
    @Override
    public Object visit(ASTArgList node, Object data){
        //System.out.println("Start of Arglist visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTBinaryArithOp node, Object data){
        System.out.println("Start of BinaryArithOp visitor");

        // Node LHS_Node =  node.jjtGetParent().jjtGetParent().jjtGetChild(0);
        // ArithSymbol = node.child.[0]
        // Node RHS_Node = node.jjtGetChild(1);

        //try getting to a decent root of the nodes, then iteraively find the value
        Node lhs = node.jjtGetParent().jjtGetParent().jjtGetChild(0);
        Node rhs = node.jjtGetChild(1);

        while(lhs.jjtGetNumChildren() > 0){
            lhs = lhs.jjtGetChild(0);

        }

        while(rhs.jjtGetNumChildren() > 0){
            rhs = rhs.jjtGetChild(0);
        }

        SimpleNode lhsSimpleNode = (SimpleNode) lhs;
        SimpleNode rhsSimpleNode = (SimpleNode) rhs;

        System.out.println("LHS VALUE: " + lhsSimpleNode.jjtGetValue().toString());
        System.out.println("RHS VALUE: " + rhsSimpleNode.jjtGetValue().toString());

        //Objects.equals(hashTableEntry.type, "integer")
        if(((lhsSimpleNode.jjtGetValue() == "integer") || getDataType(lhsSimpleNode, data) == DataType.TypeInteger)
                && ((rhsSimpleNode.jjtGetValue() == "integer") || getDataType(rhsSimpleNode, data) == DataType.TypeInteger)){
            System.out.println("Correct: LHS and RHS == Integers");
            return DataType.TypeInteger;
        }
        else{
            System.out.println("Error: LHS and RHS != Integers");
            return DataType.TypeUnknown;
        }

    }

    @Override
    public Object visit(ASTBinaryArithOpSign node, Object data){
        //System.out.println("Start of BinaryArithOpSign visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTCompOp node, Object data){
        //System.out.println("Start of CompOp visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTCondition node, Object data){
        //System.out.println("Start of Condition visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTConditionAlpha node, Object data){
        //System.out.println("Start of ConditionAlpha visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTConditionBeta node, Object data){
        //System.out.println("Start of ConditionBeta visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTConditionPrime node, Object data){
        //System.out.println("Start of ConditionPrime visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTConstDecl node, Object data){
        //System.out.println("Start of ConstDecl visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTDecl node, Object data){
        //System.out.println("Start of Decl visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTDeclList node, Object data){
        //System.out.println("Start of DeclList visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTExpression node, Object data){
        //System.out.println("Start of Expression visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTExpressionBeta node, Object data){
        //System.out.println("Start of ExpressionBeta visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTFragment node, Object data){
        //System.out.println("Start of Fragment visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTFragmentDelta node, Object data){
        //System.out.println("Start of FragmentDelta visitor");
        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTFragmentPrime node, Object data){
        //System.out.println("Start of FragmentPrime visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTFunction node, Object data){
        //System.out.println("Start of Function visitor");
        //
        //node.childrenAccept(this, data);
        //return (data);

        System.out.println("At function, getting type");

        return getDataType(node, data);
    }

    @Override
    public Object visit(ASTFunctionList node, Object data){
        //System.out.println("Start of FunctionList visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTID node, Object data){
        //System.out.println("Start of ID visitor");
        System.out.println("At ID, getting type");

        return getDataType(node, data);
    }

    @Override
    public Object visit(ASTMain node, Object data){
        //System.out.println("Start of Main visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTNempArgList node, Object data){
        //System.out.println("Start of NempArgList visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTNempArgListPrime node, Object data){
        //System.out.println("Start of NempArgListPrime visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTNempParameterList node, Object data){
        //System.out.println("Start of NempParameterList visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTNempParameterListPrime node, Object data){
        //System.out.println("Start of NempParameterListPrime visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTNum node, Object data){
        //System.out.println("Start of Num visitor");
        //
        //node.childrenAccept(this, data);
        System.out.println("Returning type integer of value  " + node.value);
        return DataType.TypeInteger;
    }

    @Override
    public Object visit(ASTParameterList node, Object data){
        //System.out.println("Start of ParameterList visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTStatement node, Object data){
        //System.out.println("Start of Statement visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTStatementBlock node, Object data){
        //System.out.println("Start of StatementBlock visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTStatementPrime node, Object data){
        //System.out.println("Start of StatementPrime visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTType node, Object data){
        //System.out.println("Start of Type visitor");

        node.childrenAccept(this, data);
        return (data);
    }

    @Override
    public Object visit(ASTVarDecl node, Object data){
        //System.out.println("Start of VarDecl visitor");

        node.childrenAccept(this, data);
        return (data);
    }
}
