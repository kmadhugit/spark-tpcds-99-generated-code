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
/* 018 */
/* 019 */     InternalRow i = null;
/* 020 */
/* 021 */     i = a;
/* 022 */     boolean isNullA;
/* 023 */     UTF8String primitiveA;
/* 024 */     {
/* 025 */
/* 026 */       boolean isNull1 = i.isNullAt(0);
/* 027 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 028 */       boolean isNull = isNull1;
/* 029 */       UTF8String value = value1;
/* 030 */       if (isNull) {
/* 031 */
/* 032 */         if (!false) {
/* 033 */           isNull = false;
/* 034 */           value = ((UTF8String) references[0]);
/* 035 */         }
/* 036 */       }
/* 037 */       isNullA = isNull;
/* 038 */       primitiveA = value;
/* 039 */     }
/* 040 */     i = b;
/* 041 */     boolean isNullB;
/* 042 */     UTF8String primitiveB;
/* 043 */     {
/* 044 */
/* 045 */       boolean isNull1 = i.isNullAt(0);
/* 046 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 047 */       boolean isNull = isNull1;
/* 048 */       UTF8String value = value1;
/* 049 */       if (isNull) {
/* 050 */
/* 051 */         if (!false) {
/* 052 */           isNull = false;
/* 053 */           value = ((UTF8String) references[0]);
/* 054 */         }
/* 055 */       }
/* 056 */       isNullB = isNull;
/* 057 */       primitiveB = value;
/* 058 */     }
/* 059 */     if (isNullA && isNullB) {
/* 060 */       // Nothing
/* 061 */     } else if (isNullA) {
/* 062 */       return -1;
/* 063 */     } else if (isNullB) {
/* 064 */       return 1;
/* 065 */     } else {
/* 066 */       int comp = primitiveA.compare(primitiveB);
/* 067 */       if (comp != 0) {
/* 068 */         return comp;
/* 069 */       }
/* 070 */     }
/* 071 */
/* 072 */
/* 073 */     return 0;
/* 074 */   }
/* 075 */ }
