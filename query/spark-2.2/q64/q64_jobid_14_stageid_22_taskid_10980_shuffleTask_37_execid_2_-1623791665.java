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
/* 014 */     result = new UnsafeRow(15);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 352);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 15);
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
/* 066 */   private void apply_3(InternalRow i) {
/* 067 */
/* 068 */
/* 069 */     boolean isNull12 = i.isNullAt(12);
/* 070 */     int value12 = isNull12 ? -1 : (i.getInt(12));
/* 071 */     if (isNull12) {
/* 072 */       rowWriter.setNullAt(12);
/* 073 */     } else {
/* 074 */       rowWriter.write(12, value12);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull13 = i.isNullAt(13);
/* 079 */     int value13 = isNull13 ? -1 : (i.getInt(13));
/* 080 */     if (isNull13) {
/* 081 */       rowWriter.setNullAt(13);
/* 082 */     } else {
/* 083 */       rowWriter.write(13, value13);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull14 = i.isNullAt(14);
/* 088 */     int value14 = isNull14 ? -1 : (i.getInt(14));
/* 089 */     if (isNull14) {
/* 090 */       rowWriter.setNullAt(14);
/* 091 */     } else {
/* 092 */       rowWriter.write(14, value14);
/* 093 */     }
/* 094 */
/* 095 */   }
/* 096 */
/* 097 */
/* 098 */   private void apply_0(InternalRow i) {
/* 099 */
/* 100 */
/* 101 */     boolean isNull = i.isNullAt(0);
/* 102 */     UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 103 */     if (isNull) {
/* 104 */       rowWriter.setNullAt(0);
/* 105 */     } else {
/* 106 */       rowWriter.write(0, value);
/* 107 */     }
/* 108 */
/* 109 */
/* 110 */     boolean isNull1 = i.isNullAt(1);
/* 111 */     int value1 = isNull1 ? -1 : (i.getInt(1));
/* 112 */     if (isNull1) {
/* 113 */       rowWriter.setNullAt(1);
/* 114 */     } else {
/* 115 */       rowWriter.write(1, value1);
/* 116 */     }
/* 117 */
/* 118 */
/* 119 */     boolean isNull2 = i.isNullAt(2);
/* 120 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 121 */     if (isNull2) {
/* 122 */       rowWriter.setNullAt(2);
/* 123 */     } else {
/* 124 */       rowWriter.write(2, value2);
/* 125 */     }
/* 126 */
/* 127 */
/* 128 */     boolean isNull3 = i.isNullAt(3);
/* 129 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 130 */     if (isNull3) {
/* 131 */       rowWriter.setNullAt(3);
/* 132 */     } else {
/* 133 */       rowWriter.write(3, value3);
/* 134 */     }
/* 135 */
/* 136 */   }
/* 137 */
/* 138 */
/* 139 */   private void apply_2(InternalRow i) {
/* 140 */
/* 141 */
/* 142 */     boolean isNull8 = i.isNullAt(8);
/* 143 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 144 */     if (isNull8) {
/* 145 */       rowWriter.setNullAt(8);
/* 146 */     } else {
/* 147 */       rowWriter.write(8, value8);
/* 148 */     }
/* 149 */
/* 150 */
/* 151 */     boolean isNull9 = i.isNullAt(9);
/* 152 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 153 */     if (isNull9) {
/* 154 */       rowWriter.setNullAt(9);
/* 155 */     } else {
/* 156 */       rowWriter.write(9, value9);
/* 157 */     }
/* 158 */
/* 159 */
/* 160 */     boolean isNull10 = i.isNullAt(10);
/* 161 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(10));
/* 162 */     if (isNull10) {
/* 163 */       rowWriter.setNullAt(10);
/* 164 */     } else {
/* 165 */       rowWriter.write(10, value10);
/* 166 */     }
/* 167 */
/* 168 */
/* 169 */     boolean isNull11 = i.isNullAt(11);
/* 170 */     UTF8String value11 = isNull11 ? null : (i.getUTF8String(11));
/* 171 */     if (isNull11) {
/* 172 */       rowWriter.setNullAt(11);
/* 173 */     } else {
/* 174 */       rowWriter.write(11, value11);
/* 175 */     }
/* 176 */
/* 177 */   }
/* 178 */
/* 179 */
/* 180 */   // Scala.Function1 need this
/* 181 */   public java.lang.Object apply(java.lang.Object row) {
/* 182 */     return apply((InternalRow) row);
/* 183 */   }
/* 184 */
/* 185 */   public UnsafeRow apply(InternalRow i) {
/* 186 */     holder.reset();
/* 187 */
/* 188 */     rowWriter.zeroOutNullBytes();
/* 189 */     apply_0(i);
/* 190 */     apply_1(i);
/* 191 */     apply_2(i);
/* 192 */     apply_3(i);
/* 193 */     result.setTotalSize(holder.totalSize());
/* 194 */     return result;
/* 195 */   }
/* 196 */ }
