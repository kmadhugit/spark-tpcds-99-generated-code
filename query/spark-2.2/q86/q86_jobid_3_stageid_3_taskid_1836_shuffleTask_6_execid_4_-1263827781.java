/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private int value1;
/* 009 */   private UnsafeRow result;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 012 */
/* 013 */   public SpecificUnsafeProjection(Object[] references) {
/* 014 */     this.references = references;
/* 015 */
/* 016 */     result = new UnsafeRow(1);
/* 017 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 018 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 019 */
/* 020 */   }
/* 021 */
/* 022 */   public void initialize(int partitionIndex) {
/* 023 */
/* 024 */   }
/* 025 */
/* 026 */
/* 027 */
/* 028 */   // Scala.Function1 need this
/* 029 */   public java.lang.Object apply(java.lang.Object row) {
/* 030 */     return apply((InternalRow) row);
/* 031 */   }
/* 032 */
/* 033 */   public UnsafeRow apply(InternalRow i) {
/* 034 */     boolean isNull = false;
/* 035 */
/* 036 */     value1 = 42;
/* 037 */
/* 038 */     boolean isNull2 = i.isNullAt(0);
/* 039 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 040 */     if (!isNull2) {
/* 041 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 042 */     }
/* 043 */
/* 044 */     boolean isNull3 = i.isNullAt(1);
/* 045 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(1));
/* 046 */     if (!isNull3) {
/* 047 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value3.getBaseObject(), value3.getBaseOffset(), value3.numBytes(), value1);
/* 048 */     }
/* 049 */
/* 050 */     int value4 = i.getInt(2);
/* 051 */     value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value4, value1);
/* 052 */
/* 053 */     int value = -1;
/* 054 */
/* 055 */     int remainder = value1 % 64;
/* 056 */     if (remainder < 0) {
/* 057 */       value = (remainder + 64) % 64;
/* 058 */     } else {
/* 059 */       value = remainder;
/* 060 */     }
/* 061 */     rowWriter.write(0, value);
/* 062 */     return result;
/* 063 */   }
/* 064 */ }
