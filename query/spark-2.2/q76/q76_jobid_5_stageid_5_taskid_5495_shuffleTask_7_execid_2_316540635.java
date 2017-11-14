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
/* 038 */     UTF8String value2 = i.getUTF8String(0);
/* 039 */     value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 040 */     boolean isNull3 = i.isNullAt(1);
/* 041 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 042 */     if (!isNull3) {
/* 043 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value3, value1);
/* 044 */     }
/* 045 */
/* 046 */     boolean isNull4 = i.isNullAt(2);
/* 047 */     int value4 = isNull4 ? -1 : (i.getInt(2));
/* 048 */     if (!isNull4) {
/* 049 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value4, value1);
/* 050 */     }
/* 051 */
/* 052 */     boolean isNull5 = i.isNullAt(3);
/* 053 */     int value5 = isNull5 ? -1 : (i.getInt(3));
/* 054 */     if (!isNull5) {
/* 055 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value5, value1);
/* 056 */     }
/* 057 */
/* 058 */     boolean isNull6 = i.isNullAt(4);
/* 059 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(4));
/* 060 */     if (!isNull6) {
/* 061 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value6.getBaseObject(), value6.getBaseOffset(), value6.numBytes(), value1);
/* 062 */     }
/* 063 */
/* 064 */     int value = -1;
/* 065 */
/* 066 */     int remainder = value1 % 64;
/* 067 */     if (remainder < 0) {
/* 068 */       value = (remainder + 64) % 64;
/* 069 */     } else {
/* 070 */       value = remainder;
/* 071 */     }
/* 072 */     rowWriter.write(0, value);
/* 073 */     return result;
/* 074 */   }
/* 075 */ }
