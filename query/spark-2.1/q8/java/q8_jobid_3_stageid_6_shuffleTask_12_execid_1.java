/* 001 */ public SpecificOrdering generate(Object[] references) {
/* 002 */   return new SpecificOrdering(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificOrdering extends org.apache.spark.sql.catalyst.expressions.codegen.BaseOrdering {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */
/* 009 */
/* 010 */   public SpecificOrdering(Object[] references) {
/* 011 */     this.references = references;
/* 012 */
/* 013 */   }
/* 014 */
/* 015 */
/* 016 */
/* 017 */   public int compare(InternalRow a, InternalRow b) {
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA;
/* 022 */     UTF8String primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull1 = i.isNullAt(0);
/* 026 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 027 */       boolean isNull = isNull1;
/* 028 */       UTF8String value = value1;
/* 029 */       if (isNull) {
/* 030 */
/* 031 */         Object obj = ((Expression) references[0]).eval(null);
/* 032 */         UTF8String value2 = (UTF8String) obj;
/* 033 */         if (!false) {
/* 034 */           isNull = false;
/* 035 */           value = value2;
/* 036 */         }
/* 037 */       }
/* 038 */       isNullA = isNull;
/* 039 */       primitiveA = value;
/* 040 */     }
/* 041 */     i = b;
/* 042 */     boolean isNullB;
/* 043 */     UTF8String primitiveB;
/* 044 */     {
/* 045 */
/* 046 */       boolean isNull1 = i.isNullAt(0);
/* 047 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 048 */       boolean isNull = isNull1;
/* 049 */       UTF8String value = value1;
/* 050 */       if (isNull) {
/* 051 */
/* 052 */         Object obj = ((Expression) references[0]).eval(null);
/* 053 */         UTF8String value2 = (UTF8String) obj;
/* 054 */         if (!false) {
/* 055 */           isNull = false;
/* 056 */           value = value2;
/* 057 */         }
/* 058 */       }
/* 059 */       isNullB = isNull;
/* 060 */       primitiveB = value;
/* 061 */     }
/* 062 */     if (isNullA && isNullB) {
/* 063 */       // Nothing
/* 064 */     } else if (isNullA) {
/* 065 */       return -1;
/* 066 */     } else if (isNullB) {
/* 067 */       return 1;
/* 068 */     } else {
/* 069 */       int comp = primitiveA.compare(primitiveB);
/* 070 */       if (comp != 0) {
/* 071 */         return comp;
/* 072 */       }
/* 073 */     }
/* 074 */
/* 075 */     return 0;
/* 076 */   }
/* 077 */ }
