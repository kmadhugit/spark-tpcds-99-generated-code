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
/* 014 */     result = new UnsafeRow(1);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
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
/* 035 */     boolean isNull2 = i.isNullAt(0);
/* 036 */     int value2 = isNull2 ? -1 : (i.getInt(0));
/* 037 */     boolean isNull1 = isNull2;
/* 038 */     long value1 = -1L;
/* 039 */     if (!isNull2) {
/* 040 */       value1 = (long) value2;
/* 041 */     }
/* 042 */     long value = 0L;
/* 043 */     boolean isNull = isNull1;
/* 044 */     if (!isNull1) {
/* 045 */       value = (long) value1;
/* 046 */     }
/* 047 */     if (isNull) {
/* 048 */       rowWriter.setNullAt(0);
/* 049 */     } else {
/* 050 */       rowWriter.write(0, value);
/* 051 */     }
/* 052 */     return result;
/* 053 */   }
/* 054 */ }
