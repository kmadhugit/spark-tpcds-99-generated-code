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
/* 027 */   private void apply_1(InternalRow i) {
/* 028 */
/* 029 */     boolean isNull6 = i.isNullAt(4);
/* 030 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(4));
/* 031 */     if (!isNull6) {
/* 032 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value6.getBaseObject(), value6.getBaseOffset(), value6.numBytes(), value1);
/* 033 */     }
/* 034 */
/* 035 */   }
/* 036 */
/* 037 */
/* 038 */   private void apply_0(InternalRow i) {
/* 039 */
/* 040 */     boolean isNull2 = i.isNullAt(0);
/* 041 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 042 */     if (!isNull2) {
/* 043 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 044 */     }
/* 045 */
/* 046 */     boolean isNull3 = i.isNullAt(1);
/* 047 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(1));
/* 048 */     if (!isNull3) {
/* 049 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value3.getBaseObject(), value3.getBaseOffset(), value3.numBytes(), value1);
/* 050 */     }
/* 051 */
/* 052 */     boolean isNull4 = i.isNullAt(2);
/* 053 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(2));
/* 054 */     if (!isNull4) {
/* 055 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value4.getBaseObject(), value4.getBaseOffset(), value4.numBytes(), value1);
/* 056 */     }
/* 057 */
/* 058 */     boolean isNull5 = i.isNullAt(3);
/* 059 */     int value5 = isNull5 ? -1 : (i.getInt(3));
/* 060 */     if (!isNull5) {
/* 061 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value5, value1);
/* 062 */     }
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */
/* 067 */   // Scala.Function1 need this
/* 068 */   public java.lang.Object apply(java.lang.Object row) {
/* 069 */     return apply((InternalRow) row);
/* 070 */   }
/* 071 */
/* 072 */   public UnsafeRow apply(InternalRow i) {
/* 073 */     boolean isNull = false;
/* 074 */
/* 075 */     value1 = 42;
/* 076 */     apply_0(i);
/* 077 */     apply_1(i);
/* 078 */
/* 079 */     int value = -1;
/* 080 */
/* 081 */     int remainder = value1 % 64;
/* 082 */     if (remainder < 0) {
/* 083 */       value = (remainder + 64) % 64;
/* 084 */     } else {
/* 085 */       value = remainder;
/* 086 */     }
/* 087 */     rowWriter.write(0, value);
/* 088 */     return result;
/* 089 */   }
/* 090 */ }
