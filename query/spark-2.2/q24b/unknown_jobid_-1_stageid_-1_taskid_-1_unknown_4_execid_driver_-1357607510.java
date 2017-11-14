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
/* 014 */     result = new UnsafeRow(2);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 64);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 2);
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
/* 032 */     holder.reset();
/* 033 */
/* 034 */     rowWriter.zeroOutNullBytes();
/* 035 */
/* 036 */
/* 037 */     boolean isNull1 = i.isNullAt(2);
/* 038 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(2));
/* 039 */     boolean isNull = isNull1;
/* 040 */     UTF8String value = null;
/* 041 */
/* 042 */     if (!isNull1) {
/* 043 */       value = (value1).toUpperCase();
/* 044 */     }
/* 045 */     if (isNull) {
/* 046 */       rowWriter.setNullAt(0);
/* 047 */     } else {
/* 048 */       rowWriter.write(0, value);
/* 049 */     }
/* 050 */
/* 051 */
/* 052 */     boolean isNull2 = i.isNullAt(1);
/* 053 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(1));
/* 054 */     if (isNull2) {
/* 055 */       rowWriter.setNullAt(1);
/* 056 */     } else {
/* 057 */       rowWriter.write(1, value2);
/* 058 */     }
/* 059 */     result.setTotalSize(holder.totalSize());
/* 060 */     return result;
/* 061 */   }
/* 062 */ }
