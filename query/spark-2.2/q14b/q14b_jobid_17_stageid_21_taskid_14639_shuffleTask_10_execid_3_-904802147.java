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
/* 023 */     int value3 = isNull3 ? -1 : (i.getInt(0));
/* 024 */     boolean isNull4 = i.isNullAt(3);
/* 025 */     int value4 = isNull4 ? -1 : (i.getInt(3));
/* 026 */     boolean value2 = (isNull3 && isNull4) ||
/* 027 */     (!isNull3 && !isNull4 && value3 == value4);
/* 028 */     boolean value1 = false;
/* 029 */
/* 030 */     if (value2) {
/* 031 */
/* 032 */       boolean isNull6 = i.isNullAt(1);
/* 033 */       int value6 = isNull6 ? -1 : (i.getInt(1));
/* 034 */       boolean isNull7 = i.isNullAt(4);
/* 035 */       int value7 = isNull7 ? -1 : (i.getInt(4));
/* 036 */       boolean value5 = (isNull6 && isNull7) ||
/* 037 */       (!isNull6 && !isNull7 && value6 == value7);
/* 038 */       value1 = value5;
/* 039 */     }
/* 040 */     boolean value = false;
/* 041 */
/* 042 */     if (value1) {
/* 043 */
/* 044 */       boolean isNull9 = i.isNullAt(2);
/* 045 */       int value9 = isNull9 ? -1 : (i.getInt(2));
/* 046 */       boolean isNull10 = i.isNullAt(5);
/* 047 */       int value10 = isNull10 ? -1 : (i.getInt(5));
/* 048 */       boolean value8 = (isNull9 && isNull10) ||
/* 049 */       (!isNull9 && !isNull10 && value9 == value10);
/* 050 */       value = value8;
/* 051 */     }
/* 052 */     return !false && value;
/* 053 */   }
/* 054 */ }
