/* 001 */ public SpecificPredicate generate(Object[] references) {
/* 002 */   return new SpecificPredicate(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificPredicate extends org.apache.spark.sql.catalyst.expressions.codegen.Predicate {
/* 006 */   private final Object[] references;
/* 007 */
/* 008 */
/* 009 */   public SpecificPredicate(Object[] references) {
/* 010 */     this.references = references;
/* 011 */
/* 012 */   }
/* 013 */
/* 014 */   public void initialize(int partitionIndex) {
/* 015 */
/* 016 */   }
/* 017 */
/* 018 */
/* 019 */
/* 020 */   public boolean eval(InternalRow i) {
/* 021 */
/* 022 */     boolean isNull3 = i.isNullAt(0);
/* 023 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(0));
/* 024 */     boolean isNull4 = i.isNullAt(3);
/* 025 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(3));
/* 026 */     boolean value2 = (isNull3 && isNull4) ||
/* 027 */     (!isNull3 && !isNull4 && value3.equals(value4));
/* 028 */     boolean value1 = false;
/* 029 */
/* 030 */     if (value2) {
/* 031 */
/* 032 */       boolean isNull6 = i.isNullAt(1);
/* 033 */       UTF8String value6 = isNull6 ? null : (i.getUTF8String(1));
/* 034 */       boolean isNull7 = i.isNullAt(4);
/* 035 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(4));
/* 036 */       boolean value5 = (isNull6 && isNull7) ||
/* 037 */       (!isNull6 && !isNull7 && value6.equals(value7));
/* 038 */       value1 = value5;
/* 039 */     }
/* 040 */     boolean value = false;
/* 041 */
/* 042 */     if (value1) {
/* 043 */
/* 044 */       boolean isNull9 = i.isNullAt(2);
/* 045 */       UTF8String value9 = isNull9 ? null : (i.getUTF8String(2));
/* 046 */       boolean isNull10 = i.isNullAt(5);
/* 047 */       UTF8String value10 = isNull10 ? null : (i.getUTF8String(5));
/* 048 */       boolean value8 = (isNull9 && isNull10) ||
/* 049 */       (!isNull9 && !isNull10 && value9.equals(value10));
/* 050 */       value = value8;
/* 051 */     }
/* 052 */     return !false && value;
/* 053 */   }
/* 054 */ }
