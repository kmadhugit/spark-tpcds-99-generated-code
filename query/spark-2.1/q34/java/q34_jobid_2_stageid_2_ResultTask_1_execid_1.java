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
/* 057 */     project_result = new UnsafeRow(1);
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
/* 077 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
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
/* 089 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 090 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 091 */
/* 092 */         boolean filter_isNull2 = true;
/* 093 */         boolean filter_value2 = false;
/* 094 */
/* 095 */         if (!scan_isNull2) {
/* 096 */           filter_isNull2 = false; // resultCode could change nullability.
/* 097 */           filter_value2 = scan_value2 >= 1;
/* 098 */
/* 099 */         }
/* 100 */         boolean filter_isNull1 = false;
/* 101 */         boolean filter_value1 = false;
/* 102 */
/* 103 */         if (!filter_isNull2 && !filter_value2) {
/* 104 */         } else {
/* 105 */           boolean filter_isNull5 = true;
/* 106 */           boolean filter_value5 = false;
/* 107 */
/* 108 */           if (!scan_isNull2) {
/* 109 */             filter_isNull5 = false; // resultCode could change nullability.
/* 110 */             filter_value5 = scan_value2 <= 3;
/* 111 */
/* 112 */           }
/* 113 */           if (!filter_isNull5 && !filter_value5) {
/* 114 */           } else if (!filter_isNull2 && !filter_isNull5) {
/* 115 */             filter_value1 = true;
/* 116 */           } else {
/* 117 */             filter_isNull1 = true;
/* 118 */           }
/* 119 */         }
/* 120 */         boolean filter_isNull = false;
/* 121 */         boolean filter_value = true;
/* 122 */
/* 123 */         if (!filter_isNull1 && filter_value1) {
/* 124 */         } else {
/* 125 */           boolean filter_isNull9 = true;
/* 126 */           boolean filter_value9 = false;
/* 127 */
/* 128 */           if (!scan_isNull2) {
/* 129 */             filter_isNull9 = false; // resultCode could change nullability.
/* 130 */             filter_value9 = scan_value2 >= 25;
/* 131 */
/* 132 */           }
/* 133 */           boolean filter_isNull8 = false;
/* 134 */           boolean filter_value8 = false;
/* 135 */
/* 136 */           if (!filter_isNull9 && !filter_value9) {
/* 137 */           } else {
/* 138 */             boolean filter_isNull12 = true;
/* 139 */             boolean filter_value12 = false;
/* 140 */
/* 141 */             if (!scan_isNull2) {
/* 142 */               filter_isNull12 = false; // resultCode could change nullability.
/* 143 */               filter_value12 = scan_value2 <= 28;
/* 144 */
/* 145 */             }
/* 146 */             if (!filter_isNull12 && !filter_value12) {
/* 147 */             } else if (!filter_isNull9 && !filter_isNull12) {
/* 148 */               filter_value8 = true;
/* 149 */             } else {
/* 150 */               filter_isNull8 = true;
/* 151 */             }
/* 152 */           }
/* 153 */           if (!filter_isNull8 && filter_value8) {
/* 154 */           } else if (!filter_isNull1 && !filter_isNull8) {
/* 155 */             filter_value = false;
/* 156 */           } else {
/* 157 */             filter_isNull = true;
/* 158 */           }
/* 159 */         }
/* 160 */         if (filter_isNull || !filter_value) continue;
/* 161 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 162 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 163 */
/* 164 */         boolean filter_value15 = false;
/* 165 */         boolean filter_isNull15 = scan_isNull1;
/* 166 */         if (!filter_isNull15) {
/* 167 */           if (!filter_value15) {
/* 168 */             if (false) {
/* 169 */               filter_isNull15 = true;
/* 170 */             } else if (scan_value1 == 1999) {
/* 171 */               filter_isNull15 = false;
/* 172 */               filter_value15 = true;
/* 173 */             }
/* 174 */           }
/* 175 */
/* 176 */           if (!filter_value15) {
/* 177 */             if (false) {
/* 178 */               filter_isNull15 = true;
/* 179 */             } else if (scan_value1 == 2000) {
/* 180 */               filter_isNull15 = false;
/* 181 */               filter_value15 = true;
/* 182 */             }
/* 183 */           }
/* 184 */
/* 185 */           if (!filter_value15) {
/* 186 */             if (false) {
/* 187 */               filter_isNull15 = true;
/* 188 */             } else if (scan_value1 == 2001) {
/* 189 */               filter_isNull15 = false;
/* 190 */               filter_value15 = true;
/* 191 */             }
/* 192 */           }
/* 193 */
/* 194 */         }
/* 195 */         if (filter_isNull15 || !filter_value15) continue;
/* 196 */
/* 197 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 198 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 199 */
/* 200 */         if (!(!(scan_isNull))) continue;
/* 201 */
/* 202 */         filter_numOutputRows.add(1);
/* 203 */
/* 204 */         project_rowWriter.write(0, scan_value);
/* 205 */         append(project_result);
/* 206 */         if (shouldStop()) return;
/* 207 */       }
/* 208 */       scan_batch = null;
/* 209 */       scan_nextBatch();
/* 210 */     }
/* 211 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 212 */     scan_scanTime1 = 0;
/* 213 */   }
/* 214 */ }
