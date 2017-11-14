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
/* 022 */     boolean isNull1 = true;
/* 023 */     boolean value1 = false;
/* 024 */
/* 025 */     boolean isNull2 = i.isNullAt(14);
/* 026 */     int value2 = isNull2 ? -1 : (i.getInt(14));
/* 027 */     if (!isNull2) {
/* 028 */
/* 029 */       boolean isNull3 = i.isNullAt(48);
/* 030 */       int value3 = isNull3 ? -1 : (i.getInt(48));
/* 031 */       if (!isNull3) {
/* 032 */
/* 033 */         isNull1 = false; // resultCode could change nullability.
/* 034 */         value1 = value2 == value3;
/* 035 */
/* 036 */       }
/* 037 */
/* 038 */     }
/* 039 */     boolean isNull = isNull1;
/* 040 */     boolean value = false;
/* 041 */
/* 042 */     if (!isNull1) {
/* 043 */       value = !(value1);
/* 044 */     }
/* 045 */     return !isNull && value;
/* 046 */   }
/* 047 */ }
