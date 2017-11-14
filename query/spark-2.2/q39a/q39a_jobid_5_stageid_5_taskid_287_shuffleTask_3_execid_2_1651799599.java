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
/* 014 */     result = new UnsafeRow(5);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 5);
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
/* 035 */     rowWriter.write(0, 0.0D);
/* 036 */
/* 037 */
/* 038 */     rowWriter.write(1, 0.0D);
/* 039 */
/* 040 */
/* 041 */     rowWriter.write(2, 0.0D);
/* 042 */
/* 043 */
/* 044 */     boolean isNull3 = false;
/* 045 */     double value3 = -1.0;
/* 046 */     if (!false) {
/* 047 */       value3 = (double) 0;
/* 048 */     }
/* 049 */     if (isNull3) {
/* 050 */       rowWriter.setNullAt(3);
/* 051 */     } else {
/* 052 */       rowWriter.write(3, value3);
/* 053 */     }
/* 054 */
/* 055 */
/* 056 */     rowWriter.write(4, 0L);
/* 057 */     return result;
/* 058 */   }
/* 059 */ }
