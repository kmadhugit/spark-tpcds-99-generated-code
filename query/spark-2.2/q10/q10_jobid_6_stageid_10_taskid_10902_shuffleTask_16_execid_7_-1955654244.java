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
/* 014 */     result = new UnsafeRow(19);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 288);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 19);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_4(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     boolean isNull17 = i.isNullAt(17);
/* 029 */     UTF8String value17 = isNull17 ? null : (i.getUTF8String(17));
/* 030 */     if (isNull17) {
/* 031 */       rowWriter.setNullAt(17);
/* 032 */     } else {
/* 033 */       rowWriter.write(17, value17);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean value18 = i.getBoolean(18);
/* 038 */     rowWriter.write(18, value18);
/* 039 */
/* 040 */   }
/* 041 */
/* 042 */
/* 043 */   private void apply_1(InternalRow i) {
/* 044 */
/* 045 */
/* 046 */     boolean isNull5 = i.isNullAt(5);
/* 047 */     int value5 = isNull5 ? -1 : (i.getInt(5));
/* 048 */     if (isNull5) {
/* 049 */       rowWriter.setNullAt(5);
/* 050 */     } else {
/* 051 */       rowWriter.write(5, value5);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull6 = i.isNullAt(6);
/* 056 */     int value6 = isNull6 ? -1 : (i.getInt(6));
/* 057 */     if (isNull6) {
/* 058 */       rowWriter.setNullAt(6);
/* 059 */     } else {
/* 060 */       rowWriter.write(6, value6);
/* 061 */     }
/* 062 */
/* 063 */
/* 064 */     boolean isNull7 = i.isNullAt(7);
/* 065 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 066 */     if (isNull7) {
/* 067 */       rowWriter.setNullAt(7);
/* 068 */     } else {
/* 069 */       rowWriter.write(7, value7);
/* 070 */     }
/* 071 */
/* 072 */
/* 073 */     boolean isNull8 = i.isNullAt(8);
/* 074 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 075 */     if (isNull8) {
/* 076 */       rowWriter.setNullAt(8);
/* 077 */     } else {
/* 078 */       rowWriter.write(8, value8);
/* 079 */     }
/* 080 */
/* 081 */   }
/* 082 */
/* 083 */
/* 084 */   private void apply_3(InternalRow i) {
/* 085 */
/* 086 */
/* 087 */     boolean isNull13 = i.isNullAt(13);
/* 088 */     int value13 = isNull13 ? -1 : (i.getInt(13));
/* 089 */     if (isNull13) {
/* 090 */       rowWriter.setNullAt(13);
/* 091 */     } else {
/* 092 */       rowWriter.write(13, value13);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull14 = i.isNullAt(14);
/* 097 */     UTF8String value14 = isNull14 ? null : (i.getUTF8String(14));
/* 098 */     if (isNull14) {
/* 099 */       rowWriter.setNullAt(14);
/* 100 */     } else {
/* 101 */       rowWriter.write(14, value14);
/* 102 */     }
/* 103 */
/* 104 */
/* 105 */     boolean isNull15 = i.isNullAt(15);
/* 106 */     UTF8String value15 = isNull15 ? null : (i.getUTF8String(15));
/* 107 */     if (isNull15) {
/* 108 */       rowWriter.setNullAt(15);
/* 109 */     } else {
/* 110 */       rowWriter.write(15, value15);
/* 111 */     }
/* 112 */
/* 113 */
/* 114 */     boolean isNull16 = i.isNullAt(16);
/* 115 */     UTF8String value16 = isNull16 ? null : (i.getUTF8String(16));
/* 116 */     if (isNull16) {
/* 117 */       rowWriter.setNullAt(16);
/* 118 */     } else {
/* 119 */       rowWriter.write(16, value16);
/* 120 */     }
/* 121 */
/* 122 */   }
/* 123 */
/* 124 */
/* 125 */   private void apply_0(InternalRow i) {
/* 126 */
/* 127 */
/* 128 */     boolean isNull = i.isNullAt(0);
/* 129 */     int value = isNull ? -1 : (i.getInt(0));
/* 130 */     if (isNull) {
/* 131 */       rowWriter.setNullAt(0);
/* 132 */     } else {
/* 133 */       rowWriter.write(0, value);
/* 134 */     }
/* 135 */
/* 136 */
/* 137 */     boolean isNull1 = i.isNullAt(1);
/* 138 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 139 */     if (isNull1) {
/* 140 */       rowWriter.setNullAt(1);
/* 141 */     } else {
/* 142 */       rowWriter.write(1, value1);
/* 143 */     }
/* 144 */
/* 145 */
/* 146 */     boolean isNull2 = i.isNullAt(2);
/* 147 */     int value2 = isNull2 ? -1 : (i.getInt(2));
/* 148 */     if (isNull2) {
/* 149 */       rowWriter.setNullAt(2);
/* 150 */     } else {
/* 151 */       rowWriter.write(2, value2);
/* 152 */     }
/* 153 */
/* 154 */
/* 155 */     boolean isNull3 = i.isNullAt(3);
/* 156 */     int value3 = isNull3 ? -1 : (i.getInt(3));
/* 157 */     if (isNull3) {
/* 158 */       rowWriter.setNullAt(3);
/* 159 */     } else {
/* 160 */       rowWriter.write(3, value3);
/* 161 */     }
/* 162 */
/* 163 */
/* 164 */     boolean isNull4 = i.isNullAt(4);
/* 165 */     int value4 = isNull4 ? -1 : (i.getInt(4));
/* 166 */     if (isNull4) {
/* 167 */       rowWriter.setNullAt(4);
/* 168 */     } else {
/* 169 */       rowWriter.write(4, value4);
/* 170 */     }
/* 171 */
/* 172 */   }
/* 173 */
/* 174 */
/* 175 */   private void apply_2(InternalRow i) {
/* 176 */
/* 177 */
/* 178 */     boolean isNull9 = i.isNullAt(9);
/* 179 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 180 */     if (isNull9) {
/* 181 */       rowWriter.setNullAt(9);
/* 182 */     } else {
/* 183 */       rowWriter.write(9, value9);
/* 184 */     }
/* 185 */
/* 186 */
/* 187 */     boolean isNull10 = i.isNullAt(10);
/* 188 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(10));
/* 189 */     if (isNull10) {
/* 190 */       rowWriter.setNullAt(10);
/* 191 */     } else {
/* 192 */       rowWriter.write(10, value10);
/* 193 */     }
/* 194 */
/* 195 */
/* 196 */     boolean isNull11 = i.isNullAt(11);
/* 197 */     int value11 = isNull11 ? -1 : (i.getInt(11));
/* 198 */     if (isNull11) {
/* 199 */       rowWriter.setNullAt(11);
/* 200 */     } else {
/* 201 */       rowWriter.write(11, value11);
/* 202 */     }
/* 203 */
/* 204 */
/* 205 */     boolean isNull12 = i.isNullAt(12);
/* 206 */     int value12 = isNull12 ? -1 : (i.getInt(12));
/* 207 */     if (isNull12) {
/* 208 */       rowWriter.setNullAt(12);
/* 209 */     } else {
/* 210 */       rowWriter.write(12, value12);
/* 211 */     }
/* 212 */
/* 213 */   }
/* 214 */
/* 215 */
/* 216 */   // Scala.Function1 need this
/* 217 */   public java.lang.Object apply(java.lang.Object row) {
/* 218 */     return apply((InternalRow) row);
/* 219 */   }
/* 220 */
/* 221 */   public UnsafeRow apply(InternalRow i) {
/* 222 */     holder.reset();
/* 223 */
/* 224 */     rowWriter.zeroOutNullBytes();
/* 225 */     apply_0(i);
/* 226 */     apply_1(i);
/* 227 */     apply_2(i);
/* 228 */     apply_3(i);
/* 229 */     apply_4(i);
/* 230 */     result.setTotalSize(holder.totalSize());
/* 231 */     return result;
/* 232 */   }
/* 233 */ }
