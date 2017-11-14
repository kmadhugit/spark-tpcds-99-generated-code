/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private UnsafeRow scan_result;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 021 */   private UnsafeRow filter_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     wholestagecodegen_init_0();
/* 036 */     wholestagecodegen_init_1();
/* 037 */
/* 038 */   }
/* 039 */
/* 040 */   private void wholestagecodegen_init_0() {
/* 041 */     scan_input = inputs[0];
/* 042 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     scan_scanTime1 = 0;
/* 045 */     scan_batch = null;
/* 046 */     scan_batchIdx = 0;
/* 047 */     scan_colInstance0 = null;
/* 048 */     scan_colInstance1 = null;
/* 049 */     scan_colInstance2 = null;
/* 050 */     scan_result = new UnsafeRow(3);
/* 051 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 052 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 053 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 054 */     filter_result = new UnsafeRow(3);
/* 055 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 056 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 057 */     project_result = new UnsafeRow(3);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */   private void scan_nextBatch() throws java.io.IOException {
/* 063 */     long getBatchStart = System.nanoTime();
/* 064 */     if (scan_input.hasNext()) {
/* 065 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 066 */       scan_numOutputRows.add(scan_batch.numRows());
/* 067 */       scan_batchIdx = 0;
/* 068 */       scan_colInstance0 = scan_batch.column(0);
/* 069 */       scan_colInstance1 = scan_batch.column(1);
/* 070 */       scan_colInstance2 = scan_batch.column(2);
/* 071 */
/* 072 */     }
/* 073 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 074 */   }
/* 075 */
/* 076 */   private void wholestagecodegen_init_1() {
/* 077 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 078 */
/* 079 */   }
/* 080 */
/* 081 */   protected void processNext() throws java.io.IOException {
/* 082 */     if (scan_batch == null) {
/* 083 */       scan_nextBatch();
/* 084 */     }
/* 085 */     while (scan_batch != null) {
/* 086 */       int numRows = scan_batch.numRows();
/* 087 */       while (scan_batchIdx < numRows) {
/* 088 */         int scan_rowIdx = scan_batchIdx++;
/* 089 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 090 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 091 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 092 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 093 */
/* 094 */         boolean filter_isNull2 = true;
/* 095 */         boolean filter_value2 = false;
/* 096 */
/* 097 */         if (!scan_isNull1) {
/* 098 */           filter_isNull2 = false; // resultCode could change nullability.
/* 099 */           filter_value2 = scan_value1 == 1999;
/* 100 */
/* 101 */         }
/* 102 */         boolean filter_isNull1 = false;
/* 103 */         boolean filter_value1 = true;
/* 104 */
/* 105 */         if (!filter_isNull2 && filter_value2) {
/* 106 */         } else {
/* 107 */           boolean filter_isNull6 = true;
/* 108 */           boolean filter_value6 = false;
/* 109 */
/* 110 */           if (!scan_isNull1) {
/* 111 */             filter_isNull6 = false; // resultCode could change nullability.
/* 112 */             filter_value6 = scan_value1 == 1998;
/* 113 */
/* 114 */           }
/* 115 */           boolean filter_isNull5 = false;
/* 116 */           boolean filter_value5 = false;
/* 117 */
/* 118 */           if (!filter_isNull6 && !filter_value6) {
/* 119 */           } else {
/* 120 */             boolean filter_isNull9 = true;
/* 121 */             boolean filter_value9 = false;
/* 122 */
/* 123 */             if (!scan_isNull2) {
/* 124 */               filter_isNull9 = false; // resultCode could change nullability.
/* 125 */               filter_value9 = scan_value2 == 12;
/* 126 */
/* 127 */             }
/* 128 */             if (!filter_isNull9 && !filter_value9) {
/* 129 */             } else if (!filter_isNull6 && !filter_isNull9) {
/* 130 */               filter_value5 = true;
/* 131 */             } else {
/* 132 */               filter_isNull5 = true;
/* 133 */             }
/* 134 */           }
/* 135 */           if (!filter_isNull5 && filter_value5) {
/* 136 */           } else if (!filter_isNull2 && !filter_isNull5) {
/* 137 */             filter_value1 = false;
/* 138 */           } else {
/* 139 */             filter_isNull1 = true;
/* 140 */           }
/* 141 */         }
/* 142 */         boolean filter_isNull = false;
/* 143 */         boolean filter_value = true;
/* 144 */
/* 145 */         if (!filter_isNull1 && filter_value1) {
/* 146 */         } else {
/* 147 */           boolean filter_isNull13 = true;
/* 148 */           boolean filter_value13 = false;
/* 149 */
/* 150 */           if (!scan_isNull1) {
/* 151 */             filter_isNull13 = false; // resultCode could change nullability.
/* 152 */             filter_value13 = scan_value1 == 2000;
/* 153 */
/* 154 */           }
/* 155 */           boolean filter_isNull12 = false;
/* 156 */           boolean filter_value12 = false;
/* 157 */
/* 158 */           if (!filter_isNull13 && !filter_value13) {
/* 159 */           } else {
/* 160 */             boolean filter_isNull16 = true;
/* 161 */             boolean filter_value16 = false;
/* 162 */
/* 163 */             if (!scan_isNull2) {
/* 164 */               filter_isNull16 = false; // resultCode could change nullability.
/* 165 */               filter_value16 = scan_value2 == 1;
/* 166 */
/* 167 */             }
/* 168 */             if (!filter_isNull16 && !filter_value16) {
/* 169 */             } else if (!filter_isNull13 && !filter_isNull16) {
/* 170 */               filter_value12 = true;
/* 171 */             } else {
/* 172 */               filter_isNull12 = true;
/* 173 */             }
/* 174 */           }
/* 175 */           if (!filter_isNull12 && filter_value12) {
/* 176 */           } else if (!filter_isNull1 && !filter_isNull12) {
/* 177 */             filter_value = false;
/* 178 */           } else {
/* 179 */             filter_isNull = true;
/* 180 */           }
/* 181 */         }
/* 182 */         if (filter_isNull || !filter_value) continue;
/* 183 */
/* 184 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 185 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 186 */
/* 187 */         if (!(!(scan_isNull))) continue;
/* 188 */
/* 189 */         filter_numOutputRows.add(1);
/* 190 */
/* 191 */         project_rowWriter.zeroOutNullBytes();
/* 192 */
/* 193 */         project_rowWriter.write(0, scan_value);
/* 194 */
/* 195 */         if (scan_isNull1) {
/* 196 */           project_rowWriter.setNullAt(1);
/* 197 */         } else {
/* 198 */           project_rowWriter.write(1, scan_value1);
/* 199 */         }
/* 200 */
/* 201 */         if (scan_isNull2) {
/* 202 */           project_rowWriter.setNullAt(2);
/* 203 */         } else {
/* 204 */           project_rowWriter.write(2, scan_value2);
/* 205 */         }
/* 206 */         append(project_result);
/* 207 */         if (shouldStop()) return;
/* 208 */       }
/* 209 */       scan_batch = null;
/* 210 */       scan_nextBatch();
/* 211 */     }
/* 212 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 213 */     scan_scanTime1 = 0;
/* 214 */   }
/* 215 */ }
