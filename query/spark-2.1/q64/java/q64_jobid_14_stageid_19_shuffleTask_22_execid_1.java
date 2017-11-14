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
/* 035 */     rowWriter.write(0, 0L);
/* 036 */
/* 037 */
/* 038 */     final double value1 = -1.0;
/* 039 */     if (true) {
/* 040 */       rowWriter.setNullAt(1);
/* 041 */     } else {
/* 042 */       rowWriter.write(1, value1);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     final double value2 = -1.0;
/* 047 */     if (true) {
/* 048 */       rowWriter.setNullAt(2);
/* 049 */     } else {
/* 050 */       rowWriter.write(2, value2);
/* 051 */     }
/* 052 */
/* 053 */
/* 054 */     final double value3 = -1.0;
/* 055 */     if (true) {
/* 056 */       rowWriter.setNullAt(3);
/* 057 */     } else {
/* 058 */       rowWriter.write(3, value3);
/* 059 */     }
/* 060 */     return result;
/* 061 */   }
/* 062 */ }
