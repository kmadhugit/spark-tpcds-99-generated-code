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
/* 014 */     result = new UnsafeRow(8);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 224);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 8);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     boolean isNull4 = i.isNullAt(4);
/* 029 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(4));
/* 030 */     if (isNull4) {
/* 031 */       rowWriter.setNullAt(4);
/* 032 */     } else {
/* 033 */       rowWriter.write(4, value4);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull5 = i.isNullAt(5);
/* 038 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(5));
/* 039 */     if (isNull5) {
/* 040 */       rowWriter.setNullAt(5);
/* 041 */     } else {
/* 042 */       rowWriter.write(5, value5);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull6 = i.isNullAt(6);
/* 047 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(6));
/* 048 */     if (isNull6) {
/* 049 */       rowWriter.setNullAt(6);
/* 050 */     } else {
/* 051 */       rowWriter.write(6, value6);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull7 = i.isNullAt(7);
/* 056 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 057 */     if (isNull7) {
/* 058 */       rowWriter.setNullAt(7);
/* 059 */     } else {
/* 060 */       rowWriter.write(7, value7);
/* 061 */     }
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */
/* 066 */   private void apply_0(InternalRow i) {
/* 067 */
/* 068 */
/* 069 */     boolean isNull = i.isNullAt(0);
/* 070 */     UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 071 */     if (isNull) {
/* 072 */       rowWriter.setNullAt(0);
/* 073 */     } else {
/* 074 */       rowWriter.write(0, value);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull1 = i.isNullAt(1);
/* 079 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 080 */     if (isNull1) {
/* 081 */       rowWriter.setNullAt(1);
/* 082 */     } else {
/* 083 */       rowWriter.write(1, value1);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull2 = i.isNullAt(2);
/* 088 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 089 */     if (isNull2) {
/* 090 */       rowWriter.setNullAt(2);
/* 091 */     } else {
/* 092 */       rowWriter.write(2, value2);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull3 = i.isNullAt(3);
/* 097 */     int value3 = isNull3 ? -1 : (i.getInt(3));
/* 098 */     if (isNull3) {
/* 099 */       rowWriter.setNullAt(3);
/* 100 */     } else {
/* 101 */       rowWriter.write(3, value3);
/* 102 */     }
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */
/* 107 */   // Scala.Function1 need this
/* 108 */   public java.lang.Object apply(java.lang.Object row) {
/* 109 */     return apply((InternalRow) row);
/* 110 */   }
/* 111 */
/* 112 */   public UnsafeRow apply(InternalRow i) {
/* 113 */     holder.reset();
/* 114 */
/* 115 */     rowWriter.zeroOutNullBytes();
/* 116 */     apply_0(i);
/* 117 */     apply_1(i);
/* 118 */     result.setTotalSize(holder.totalSize());
/* 119 */     return result;
/* 120 */   }
/* 121 */ }
