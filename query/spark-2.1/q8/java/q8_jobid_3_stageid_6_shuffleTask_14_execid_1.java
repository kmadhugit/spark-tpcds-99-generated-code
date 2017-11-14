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
/* 022 */     boolean isNull1 = i.isNullAt(0);
/* 023 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 024 */     boolean isNull2 = i.isNullAt(1);
/* 025 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(1));
/* 026 */     boolean value = (isNull1 && isNull2) ||
/* 027 */     (!isNull1 && !isNull2 && value1.equals(value2));
/* 028 */     return !false && value;
/* 029 */   }
/* 030 */ }
