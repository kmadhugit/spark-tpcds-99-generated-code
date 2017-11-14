/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private int smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private int smj_value3;
/* 015 */   private double smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private UTF8String smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private int smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private UTF8String smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private UTF8String smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private UTF8String smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 028 */   private UnsafeRow smj_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */
/* 035 */   public GeneratedIterator(Object[] references) {
/* 036 */     this.references = references;
/* 037 */   }
/* 038 */
/* 039 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 040 */     partitionIndex = index;
/* 041 */     this.inputs = inputs;
/* 042 */     smj_leftInput = inputs[0];
/* 043 */     smj_rightInput = inputs[1];
/* 044 */
/* 045 */     smj_rightRow = null;
/* 046 */
/* 047 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 048 */
/* 049 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 050 */     smj_result = new UnsafeRow(18);
/* 051 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 448);
/* 052 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 18);
/* 053 */     project_result = new UnsafeRow(16);
/* 054 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 448);
/* 055 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 16);
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private boolean findNextInnerJoinRows(
/* 060 */     scala.collection.Iterator leftIter,
/* 061 */     scala.collection.Iterator rightIter) {
/* 062 */     smj_leftRow = null;
/* 063 */     int comp = 0;
/* 064 */     while (smj_leftRow == null) {
/* 065 */       if (!leftIter.hasNext()) return false;
/* 066 */       smj_leftRow = (InternalRow) leftIter.next();
/* 067 */
/* 068 */       boolean smj_isNull = smj_leftRow.isNullAt(2);
/* 069 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(2));
/* 070 */       if (smj_isNull) {
/* 071 */         smj_leftRow = null;
/* 072 */         continue;
/* 073 */       }
/* 074 */       if (!smj_matches.isEmpty()) {
/* 075 */         comp = 0;
/* 076 */         if (comp == 0) {
/* 077 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 078 */         }
/* 079 */
/* 080 */         if (comp == 0) {
/* 081 */           return true;
/* 082 */         }
/* 083 */         smj_matches.clear();
/* 084 */       }
/* 085 */
/* 086 */       do {
/* 087 */         if (smj_rightRow == null) {
/* 088 */           if (!rightIter.hasNext()) {
/* 089 */             smj_value3 = smj_value;
/* 090 */             return !smj_matches.isEmpty();
/* 091 */           }
/* 092 */           smj_rightRow = (InternalRow) rightIter.next();
/* 093 */
/* 094 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 095 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 096 */           if (smj_isNull1) {
/* 097 */             smj_rightRow = null;
/* 098 */             continue;
/* 099 */           }
/* 100 */           smj_value2 = smj_value1;
/* 101 */         }
/* 102 */
/* 103 */         comp = 0;
/* 104 */         if (comp == 0) {
/* 105 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 106 */         }
/* 107 */
/* 108 */         if (comp > 0) {
/* 109 */           smj_rightRow = null;
/* 110 */         } else if (comp < 0) {
/* 111 */           if (!smj_matches.isEmpty()) {
/* 112 */             smj_value3 = smj_value;
/* 113 */             return true;
/* 114 */           }
/* 115 */           smj_leftRow = null;
/* 116 */         } else {
/* 117 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 118 */           smj_rightRow = null;;
/* 119 */         }
/* 120 */       } while (smj_leftRow != null);
/* 121 */     }
/* 122 */     return false; // unreachable
/* 123 */   }
/* 124 */
/* 125 */   protected void processNext() throws java.io.IOException {
/* 126 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 127 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 128 */       smj_value4 = smj_isNull2 ? -1.0 : (smj_leftRow.getDouble(0));
/* 129 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 130 */       smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 131 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 132 */       smj_value6 = smj_isNull4 ? -1 : (smj_leftRow.getInt(2));
/* 133 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 134 */       smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 135 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 136 */       smj_value8 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(4));
/* 137 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 138 */       smj_value9 = smj_isNull7 ? null : (smj_leftRow.getUTF8String(5));
/* 139 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 140 */       while (smj_iterator.hasNext()) {
/* 141 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 142 */
/* 143 */         smj_numOutputRows.add(1);
/* 144 */
/* 145 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(1);
/* 146 */         UTF8String smj_value11 = smj_isNull9 ? null : (smj_rightRow1.getUTF8String(1));
/* 147 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(2);
/* 148 */         UTF8String smj_value12 = smj_isNull10 ? null : (smj_rightRow1.getUTF8String(2));
/* 149 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(3);
/* 150 */         UTF8String smj_value13 = smj_isNull11 ? null : (smj_rightRow1.getUTF8String(3));
/* 151 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(4);
/* 152 */         UTF8String smj_value14 = smj_isNull12 ? null : (smj_rightRow1.getUTF8String(4));
/* 153 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(5);
/* 154 */         UTF8String smj_value15 = smj_isNull13 ? null : (smj_rightRow1.getUTF8String(5));
/* 155 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(6);
/* 156 */         UTF8String smj_value16 = smj_isNull14 ? null : (smj_rightRow1.getUTF8String(6));
/* 157 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(7);
/* 158 */         UTF8String smj_value17 = smj_isNull15 ? null : (smj_rightRow1.getUTF8String(7));
/* 159 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(8);
/* 160 */         UTF8String smj_value18 = smj_isNull16 ? null : (smj_rightRow1.getUTF8String(8));
/* 161 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(9);
/* 162 */         UTF8String smj_value19 = smj_isNull17 ? null : (smj_rightRow1.getUTF8String(9));
/* 163 */         boolean smj_isNull18 = smj_rightRow1.isNullAt(10);
/* 164 */         double smj_value20 = smj_isNull18 ? -1.0 : (smj_rightRow1.getDouble(10));
/* 165 */         boolean smj_isNull19 = smj_rightRow1.isNullAt(11);
/* 166 */         UTF8String smj_value21 = smj_isNull19 ? null : (smj_rightRow1.getUTF8String(11));
/* 167 */         project_holder.reset();
/* 168 */
/* 169 */         project_rowWriter.zeroOutNullBytes();
/* 170 */
/* 171 */         if (smj_isNull3) {
/* 172 */           project_rowWriter.setNullAt(0);
/* 173 */         } else {
/* 174 */           project_rowWriter.write(0, smj_value5);
/* 175 */         }
/* 176 */
/* 177 */         if (smj_isNull5) {
/* 178 */           project_rowWriter.setNullAt(1);
/* 179 */         } else {
/* 180 */           project_rowWriter.write(1, smj_value7);
/* 181 */         }
/* 182 */
/* 183 */         if (smj_isNull6) {
/* 184 */           project_rowWriter.setNullAt(2);
/* 185 */         } else {
/* 186 */           project_rowWriter.write(2, smj_value8);
/* 187 */         }
/* 188 */
/* 189 */         if (smj_isNull7) {
/* 190 */           project_rowWriter.setNullAt(3);
/* 191 */         } else {
/* 192 */           project_rowWriter.write(3, smj_value9);
/* 193 */         }
/* 194 */
/* 195 */         if (smj_isNull9) {
/* 196 */           project_rowWriter.setNullAt(4);
/* 197 */         } else {
/* 198 */           project_rowWriter.write(4, smj_value11);
/* 199 */         }
/* 200 */
/* 201 */         if (smj_isNull10) {
/* 202 */           project_rowWriter.setNullAt(5);
/* 203 */         } else {
/* 204 */           project_rowWriter.write(5, smj_value12);
/* 205 */         }
/* 206 */
/* 207 */         if (smj_isNull11) {
/* 208 */           project_rowWriter.setNullAt(6);
/* 209 */         } else {
/* 210 */           project_rowWriter.write(6, smj_value13);
/* 211 */         }
/* 212 */
/* 213 */         if (smj_isNull12) {
/* 214 */           project_rowWriter.setNullAt(7);
/* 215 */         } else {
/* 216 */           project_rowWriter.write(7, smj_value14);
/* 217 */         }
/* 218 */
/* 219 */         if (smj_isNull13) {
/* 220 */           project_rowWriter.setNullAt(8);
/* 221 */         } else {
/* 222 */           project_rowWriter.write(8, smj_value15);
/* 223 */         }
/* 224 */
/* 225 */         if (smj_isNull14) {
/* 226 */           project_rowWriter.setNullAt(9);
/* 227 */         } else {
/* 228 */           project_rowWriter.write(9, smj_value16);
/* 229 */         }
/* 230 */
/* 231 */         if (smj_isNull15) {
/* 232 */           project_rowWriter.setNullAt(10);
/* 233 */         } else {
/* 234 */           project_rowWriter.write(10, smj_value17);
/* 235 */         }
/* 236 */
/* 237 */         if (smj_isNull16) {
/* 238 */           project_rowWriter.setNullAt(11);
/* 239 */         } else {
/* 240 */           project_rowWriter.write(11, smj_value18);
/* 241 */         }
/* 242 */
/* 243 */         if (smj_isNull17) {
/* 244 */           project_rowWriter.setNullAt(12);
/* 245 */         } else {
/* 246 */           project_rowWriter.write(12, smj_value19);
/* 247 */         }
/* 248 */
/* 249 */         if (smj_isNull18) {
/* 250 */           project_rowWriter.setNullAt(13);
/* 251 */         } else {
/* 252 */           project_rowWriter.write(13, smj_value20);
/* 253 */         }
/* 254 */
/* 255 */         if (smj_isNull19) {
/* 256 */           project_rowWriter.setNullAt(14);
/* 257 */         } else {
/* 258 */           project_rowWriter.write(14, smj_value21);
/* 259 */         }
/* 260 */
/* 261 */         if (smj_isNull2) {
/* 262 */           project_rowWriter.setNullAt(15);
/* 263 */         } else {
/* 264 */           project_rowWriter.write(15, smj_value4);
/* 265 */         }
/* 266 */         project_result.setTotalSize(project_holder.totalSize());
/* 267 */         append(project_result.copy());
/* 268 */
/* 269 */       }
/* 270 */       if (shouldStop()) return;
/* 271 */     }
/* 272 */   }
/* 273 */ }
