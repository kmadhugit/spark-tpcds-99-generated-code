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
/* 012 */   private int smj_value6;
/* 013 */   private int smj_value7;
/* 014 */   private int smj_value8;
/* 015 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 016 */   private int smj_value9;
/* 017 */   private int smj_value10;
/* 018 */   private int smj_value11;
/* 019 */   private UTF8String smj_value12;
/* 020 */   private int smj_value13;
/* 021 */   private boolean smj_isNull6;
/* 022 */   private int smj_value14;
/* 023 */   private boolean smj_isNull7;
/* 024 */   private int smj_value15;
/* 025 */   private boolean smj_isNull8;
/* 026 */   private double smj_value16;
/* 027 */   private boolean smj_isNull9;
/* 028 */   private long smj_value17;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 030 */   private UnsafeRow smj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     smj_leftInput = inputs[0];
/* 042 */     smj_rightInput = inputs[1];
/* 043 */
/* 044 */     smj_rightRow = null;
/* 045 */
/* 046 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 047 */
/* 048 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 049 */     smj_result = new UnsafeRow(12);
/* 050 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 051 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */   private boolean findNextInnerJoinRows(
/* 056 */     scala.collection.Iterator leftIter,
/* 057 */     scala.collection.Iterator rightIter) {
/* 058 */     smj_leftRow = null;
/* 059 */     int comp = 0;
/* 060 */     while (smj_leftRow == null) {
/* 061 */       if (!leftIter.hasNext()) return false;
/* 062 */       smj_leftRow = (InternalRow) leftIter.next();
/* 063 */
/* 064 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 065 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 066 */
/* 067 */       boolean smj_isNull1 = smj_leftRow.isNullAt(2);
/* 068 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(2));
/* 069 */
/* 070 */       boolean smj_isNull2 = smj_leftRow.isNullAt(3);
/* 071 */       int smj_value2 = smj_isNull2 ? -1 : (smj_leftRow.getInt(3));
/* 072 */       if (smj_isNull || smj_isNull1 || smj_isNull2) {
/* 073 */         smj_leftRow = null;
/* 074 */         continue;
/* 075 */       }
/* 076 */       if (!smj_matches.isEmpty()) {
/* 077 */         comp = 0;
/* 078 */         if (comp == 0) {
/* 079 */           comp = (smj_value > smj_value9 ? 1 : smj_value < smj_value9 ? -1 : 0);
/* 080 */         }
/* 081 */         if (comp == 0) {
/* 082 */           comp = (smj_value1 > smj_value10 ? 1 : smj_value1 < smj_value10 ? -1 : 0);
/* 083 */         }
/* 084 */         if (comp == 0) {
/* 085 */           comp = (smj_value2 > smj_value11 ? 1 : smj_value2 < smj_value11 ? -1 : 0);
/* 086 */         }
/* 087 */
/* 088 */         if (comp == 0) {
/* 089 */           return true;
/* 090 */         }
/* 091 */         smj_matches.clear();
/* 092 */       }
/* 093 */
/* 094 */       do {
/* 095 */         if (smj_rightRow == null) {
/* 096 */           if (!rightIter.hasNext()) {
/* 097 */             smj_value9 = smj_value;
/* 098 */             smj_value10 = smj_value1;
/* 099 */             smj_value11 = smj_value2;
/* 100 */             return !smj_matches.isEmpty();
/* 101 */           }
/* 102 */           smj_rightRow = (InternalRow) rightIter.next();
/* 103 */
/* 104 */           boolean smj_isNull3 = smj_rightRow.isNullAt(1);
/* 105 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(1));
/* 106 */
/* 107 */           boolean smj_isNull4 = smj_rightRow.isNullAt(2);
/* 108 */           int smj_value4 = smj_isNull4 ? -1 : (smj_rightRow.getInt(2));
/* 109 */
/* 110 */           boolean smj_isNull5 = smj_rightRow.isNullAt(3);
/* 111 */           int smj_value5 = smj_isNull5 ? -1 : (smj_rightRow.getInt(3));
/* 112 */           if (smj_isNull3 || smj_isNull4 || smj_isNull5) {
/* 113 */             smj_rightRow = null;
/* 114 */             continue;
/* 115 */           }
/* 116 */           smj_value6 = smj_value3;
/* 117 */           smj_value7 = smj_value4;
/* 118 */           smj_value8 = smj_value5;
/* 119 */         }
/* 120 */
/* 121 */         comp = 0;
/* 122 */         if (comp == 0) {
/* 123 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 124 */         }
/* 125 */         if (comp == 0) {
/* 126 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 127 */         }
/* 128 */         if (comp == 0) {
/* 129 */           comp = (smj_value2 > smj_value8 ? 1 : smj_value2 < smj_value8 ? -1 : 0);
/* 130 */         }
/* 131 */
/* 132 */         if (comp > 0) {
/* 133 */           smj_rightRow = null;
/* 134 */         } else if (comp < 0) {
/* 135 */           if (!smj_matches.isEmpty()) {
/* 136 */             smj_value9 = smj_value;
/* 137 */             smj_value10 = smj_value1;
/* 138 */             smj_value11 = smj_value2;
/* 139 */             return true;
/* 140 */           }
/* 141 */           smj_leftRow = null;
/* 142 */         } else {
/* 143 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 144 */           smj_rightRow = null;;
/* 145 */         }
/* 146 */       } while (smj_leftRow != null);
/* 147 */     }
/* 148 */     return false; // unreachable
/* 149 */   }
/* 150 */
/* 151 */   protected void processNext() throws java.io.IOException {
/* 152 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 153 */       smj_value12 = smj_leftRow.getUTF8String(0);
/* 154 */       smj_isNull6 = smj_leftRow.isNullAt(1);
/* 155 */       smj_value13 = smj_isNull6 ? -1 : (smj_leftRow.getInt(1));
/* 156 */       smj_isNull7 = smj_leftRow.isNullAt(2);
/* 157 */       smj_value14 = smj_isNull7 ? -1 : (smj_leftRow.getInt(2));
/* 158 */       smj_isNull8 = smj_leftRow.isNullAt(3);
/* 159 */       smj_value15 = smj_isNull8 ? -1 : (smj_leftRow.getInt(3));
/* 160 */       smj_isNull9 = smj_leftRow.isNullAt(4);
/* 161 */       smj_value16 = smj_isNull9 ? -1.0 : (smj_leftRow.getDouble(4));
/* 162 */       smj_value17 = smj_leftRow.getLong(5);
/* 163 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 164 */       while (smj_iterator.hasNext()) {
/* 165 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 166 */
/* 167 */         smj_numOutputRows.add(1);
/* 168 */
/* 169 */         UTF8String smj_value18 = smj_rightRow1.getUTF8String(0);
/* 170 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(1);
/* 171 */         int smj_value19 = smj_isNull11 ? -1 : (smj_rightRow1.getInt(1));
/* 172 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(2);
/* 173 */         int smj_value20 = smj_isNull12 ? -1 : (smj_rightRow1.getInt(2));
/* 174 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(3);
/* 175 */         int smj_value21 = smj_isNull13 ? -1 : (smj_rightRow1.getInt(3));
/* 176 */         boolean smj_isNull14 = smj_rightRow1.isNullAt(4);
/* 177 */         double smj_value22 = smj_isNull14 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 178 */         long smj_value23 = smj_rightRow1.getLong(5);
/* 179 */         smj_holder.reset();
/* 180 */
/* 181 */         smj_rowWriter.zeroOutNullBytes();
/* 182 */
/* 183 */         smj_rowWriter.write(0, smj_value12);
/* 184 */
/* 185 */         if (smj_isNull6) {
/* 186 */           smj_rowWriter.setNullAt(1);
/* 187 */         } else {
/* 188 */           smj_rowWriter.write(1, smj_value13);
/* 189 */         }
/* 190 */
/* 191 */         if (smj_isNull7) {
/* 192 */           smj_rowWriter.setNullAt(2);
/* 193 */         } else {
/* 194 */           smj_rowWriter.write(2, smj_value14);
/* 195 */         }
/* 196 */
/* 197 */         if (smj_isNull8) {
/* 198 */           smj_rowWriter.setNullAt(3);
/* 199 */         } else {
/* 200 */           smj_rowWriter.write(3, smj_value15);
/* 201 */         }
/* 202 */
/* 203 */         if (smj_isNull9) {
/* 204 */           smj_rowWriter.setNullAt(4);
/* 205 */         } else {
/* 206 */           smj_rowWriter.write(4, smj_value16);
/* 207 */         }
/* 208 */
/* 209 */         smj_rowWriter.write(5, smj_value17);
/* 210 */
/* 211 */         smj_rowWriter.write(6, smj_value18);
/* 212 */
/* 213 */         if (smj_isNull11) {
/* 214 */           smj_rowWriter.setNullAt(7);
/* 215 */         } else {
/* 216 */           smj_rowWriter.write(7, smj_value19);
/* 217 */         }
/* 218 */
/* 219 */         if (smj_isNull12) {
/* 220 */           smj_rowWriter.setNullAt(8);
/* 221 */         } else {
/* 222 */           smj_rowWriter.write(8, smj_value20);
/* 223 */         }
/* 224 */
/* 225 */         if (smj_isNull13) {
/* 226 */           smj_rowWriter.setNullAt(9);
/* 227 */         } else {
/* 228 */           smj_rowWriter.write(9, smj_value21);
/* 229 */         }
/* 230 */
/* 231 */         if (smj_isNull14) {
/* 232 */           smj_rowWriter.setNullAt(10);
/* 233 */         } else {
/* 234 */           smj_rowWriter.write(10, smj_value22);
/* 235 */         }
/* 236 */
/* 237 */         smj_rowWriter.write(11, smj_value23);
/* 238 */         smj_result.setTotalSize(smj_holder.totalSize());
/* 239 */         append(smj_result.copy());
/* 240 */
/* 241 */       }
/* 242 */       if (shouldStop()) return;
/* 243 */     }
/* 244 */   }
/* 245 */ }
