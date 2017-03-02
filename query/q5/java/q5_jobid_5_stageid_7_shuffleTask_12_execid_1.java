/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(4);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 4);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */
/* 026 */   // Scala.Function1 need this
/* 027 */   public java.lang.Object apply(java.lang.Object row) {
/* 028 */     return apply((InternalRow) row);
/* 029 */   }
/* 030 */
/* 031 */   public UnsafeRow apply(InternalRow i) {
/* 032 */     rowWriter.zeroOutNullBytes();
/* 033 */
/* 034 */
/* 035 */     boolean isNull = i.isNullAt(0);
/* 036 */     double value = isNull ? -1.0 : (i.getDouble(0));
/* 037 */     if (isNull) {
/* 038 */       rowWriter.setNullAt(0);
/* 039 */     } else {
/* 040 */       rowWriter.write(0, value);
/* 041 */     }
/* 042 */
/* 043 */
/* 044 */     boolean isNull1 = i.isNullAt(1);
/* 045 */     double value1 = isNull1 ? -1.0 : (i.getDouble(1));
/* 046 */     if (isNull1) {
/* 047 */       rowWriter.setNullAt(1);
/* 048 */     } else {
/* 049 */       rowWriter.write(1, value1);
/* 050 */     }
/* 051 */
/* 052 */
/* 053 */     boolean isNull2 = i.isNullAt(2);
/* 054 */     double value2 = isNull2 ? -1.0 : (i.getDouble(2));
/* 055 */     if (isNull2) {
/* 056 */       rowWriter.setNullAt(2);
/* 057 */     } else {
/* 058 */       rowWriter.write(2, value2);
/* 059 */     }
/* 060 */
/* 061 */
/* 062 */     boolean isNull3 = i.isNullAt(3);
/* 063 */     double value3 = isNull3 ? -1.0 : (i.getDouble(3));
/* 064 */     if (isNull3) {
/* 065 */       rowWriter.setNullAt(3);
/* 066 */     } else {
/* 067 */       rowWriter.write(3, value3);
/* 068 */     }
/* 069 */     return result;
/* 070 */   }
/* 071 */ }
