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
/* 035 */     boolean isNull7 = i.isNullAt(5);
/* 036 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(5));
/* 037 */     if (!isNull7) {
/* 038 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value7.getBaseObject(), value7.getBaseOffset(), value7.numBytes(), value1);
/* 039 */     }
/* 040 */
/* 041 */     boolean isNull8 = i.isNullAt(6);
/* 042 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(6));
/* 043 */     if (!isNull8) {
/* 044 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value8.getBaseObject(), value8.getBaseOffset(), value8.numBytes(), value1);
/* 045 */     }
/* 046 */
/* 047 */     boolean isNull9 = i.isNullAt(7);
/* 048 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(7));
/* 049 */     if (!isNull9) {
/* 050 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value9.getBaseObject(), value9.getBaseOffset(), value9.numBytes(), value1);
/* 051 */     }
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */
/* 056 */   private void apply_3(InternalRow i) {
/* 057 */
/* 058 */     boolean isNull14 = i.isNullAt(12);
/* 059 */     int value14 = isNull14 ? -1 : (i.getInt(12));
/* 060 */     if (!isNull14) {
/* 061 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value14, value1);
/* 062 */     }
/* 063 */
/* 064 */     boolean isNull15 = i.isNullAt(13);
/* 065 */     int value15 = isNull15 ? -1 : (i.getInt(13));
/* 066 */     if (!isNull15) {
/* 067 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value15, value1);
/* 068 */     }
/* 069 */
/* 070 */     boolean isNull16 = i.isNullAt(14);
/* 071 */     int value16 = isNull16 ? -1 : (i.getInt(14));
/* 072 */     if (!isNull16) {
/* 073 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value16, value1);
/* 074 */     }
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */
/* 079 */   private void apply_0(InternalRow i) {
/* 080 */
/* 081 */     boolean isNull2 = i.isNullAt(0);
/* 082 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 083 */     if (!isNull2) {
/* 084 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 085 */     }
/* 086 */
/* 087 */     boolean isNull3 = i.isNullAt(1);
/* 088 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 089 */     if (!isNull3) {
/* 090 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value3, value1);
/* 091 */     }
/* 092 */
/* 093 */     boolean isNull4 = i.isNullAt(2);
/* 094 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(2));
/* 095 */     if (!isNull4) {
/* 096 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value4.getBaseObject(), value4.getBaseOffset(), value4.numBytes(), value1);
/* 097 */     }
/* 098 */
/* 099 */     boolean isNull5 = i.isNullAt(3);
/* 100 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(3));
/* 101 */     if (!isNull5) {
/* 102 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value5.getBaseObject(), value5.getBaseOffset(), value5.numBytes(), value1);
/* 103 */     }
/* 104 */
/* 105 */   }
/* 106 */
/* 107 */
/* 108 */   private void apply_2(InternalRow i) {
/* 109 */
/* 110 */     boolean isNull10 = i.isNullAt(8);
/* 111 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(8));
/* 112 */     if (!isNull10) {
/* 113 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value10.getBaseObject(), value10.getBaseOffset(), value10.numBytes(), value1);
/* 114 */     }
/* 115 */
/* 116 */     boolean isNull11 = i.isNullAt(9);
/* 117 */     UTF8String value11 = isNull11 ? null : (i.getUTF8String(9));
/* 118 */     if (!isNull11) {
/* 119 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value11.getBaseObject(), value11.getBaseOffset(), value11.numBytes(), value1);
/* 120 */     }
/* 121 */
/* 122 */     boolean isNull12 = i.isNullAt(10);
/* 123 */     UTF8String value12 = isNull12 ? null : (i.getUTF8String(10));
/* 124 */     if (!isNull12) {
/* 125 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value12.getBaseObject(), value12.getBaseOffset(), value12.numBytes(), value1);
/* 126 */     }
/* 127 */
/* 128 */     boolean isNull13 = i.isNullAt(11);
/* 129 */     UTF8String value13 = isNull13 ? null : (i.getUTF8String(11));
/* 130 */     if (!isNull13) {
/* 131 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value13.getBaseObject(), value13.getBaseOffset(), value13.numBytes(), value1);
/* 132 */     }
/* 133 */
/* 134 */   }
/* 135 */
/* 136 */
/* 137 */   // Scala.Function1 need this
/* 138 */   public java.lang.Object apply(java.lang.Object row) {
/* 139 */     return apply((InternalRow) row);
/* 140 */   }
/* 141 */
/* 142 */   public UnsafeRow apply(InternalRow i) {
/* 143 */     boolean isNull = false;
/* 144 */
/* 145 */     value1 = 42;
/* 146 */     apply_0(i);
/* 147 */     apply_1(i);
/* 148 */     apply_2(i);
/* 149 */     apply_3(i);
/* 150 */
/* 151 */     int value = -1;
/* 152 */
/* 153 */     int remainder = value1 % 64;
/* 154 */     if (remainder < 0) {
/* 155 */       value = (remainder + 64) % 64;
/* 156 */     } else {
/* 157 */       value = remainder;
/* 158 */     }
/* 159 */     rowWriter.write(0, value);
/* 160 */     return result;
/* 161 */   }
/* 162 */ }
